package java_reactive_demo.com.piseth.java.school;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

public class U2MonoEmptyAndError {
	
	private Mono<String> getProduct(int productId){
		return switch(productId) {
		case 1 -> Mono.just("Cocacola");
		case 2 -> Mono.empty();
		default -> Mono.error(() -> new RuntimeException("Invalid productId"));
		};
	}
	
	@Test
	public void testProduct() {
		StepVerifier.create(getProduct(1))
			.expectNext("Cocacola")
			.expectComplete()
			.verify(); // subscriber
	}
	
	@Test
	public void testEmpty() {
		StepVerifier.create(getProduct(2))
			.expectComplete()
			.verify(); 
	}
	
	@Test
	public void testError1() {
		StepVerifier.create(getProduct(3))
			.expectError()
			.verify(); 
	}
	
	@Test
	public void testError2() {
		StepVerifier.create(getProduct(3))
			.expectError(RuntimeException.class)
			.verify(); 
	}
	
	@Test
	public void testError3() {
		StepVerifier.create(getProduct(4))
			.expectErrorMessage("Invalid productId")
			.verify(); 
	}
	
	@Test
	public void testError4() {
		StepVerifier.create(getProduct(3))
			//.expectError(RuntimeException.class)
			//.expectErrorMessage("Invalid productId")
			.consumeErrorWith(err ->{
				Assertions.assertEquals(RuntimeException.class, err.getClass());
				Assertions.assertEquals("Invalid productId", err.getMessage());
			})
			.verify(); 
	}

}
