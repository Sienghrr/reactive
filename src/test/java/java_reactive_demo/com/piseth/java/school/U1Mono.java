package java_reactive_demo.com.piseth.java.school;

import org.junit.jupiter.api.Test;

import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

public class U1Mono {
	
	private Mono<String> getProduct(int productId){
		return Mono.just("product-"+productId)
				.doFirst(() -> System.out.println("Get invoked"));
	}
	
	@Test
	public void testProduct() {
		StepVerifier.create(getProduct(1))
			.expectNext("product-1")
			.expectComplete()
			.verify(); // subscriber
		
	}
	
	@Test
	public void testProduct2() {
		StepVerifier.create(getProduct(1))
			.expectNext("product-1")
			.verifyComplete();
			//.expectComplete()
			//.verify(); // subscriber
		
	}

}
