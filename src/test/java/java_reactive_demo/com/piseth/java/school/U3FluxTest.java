package java_reactive_demo.com.piseth.java.school;

import org.junit.jupiter.api.Test;

import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

public class U3FluxTest {
	
	private Flux<Integer> getItems(){
		return Flux.just(1,2,3);
	}
	
	@Test
	public void testFlux() {
		StepVerifier.create(getItems())
			.expectNext(1)
			//.expectComplete()
			.thenCancel()
			.verify();
		
	}
	
	@Test
	public void testFlux2() {
		StepVerifier.create(getItems())
			.expectNext(1)
			.expectNext(2)
			.expectNext(3)
			.expectComplete()
			.verify();
		
	}
	
	@Test
	public void testFlux3() {
		StepVerifier.create(getItems())
			.expectNext(1,2,3)
			.expectComplete()
			.verify();
		
	}

}
