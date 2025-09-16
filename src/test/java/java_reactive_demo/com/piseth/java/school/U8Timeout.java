package java_reactive_demo.com.piseth.java.school;

import java.time.Duration;

import org.junit.jupiter.api.Test;

import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;
import reactor.test.StepVerifierOptions;

public class U8Timeout {
	
	private Flux<Integer> getItems(){
		return Flux.range(1, 5).delayElements(Duration.ofMillis(200));
	}
	
	@Test
	public void testFlux() {
		StepVerifier.create(getItems())
			.expectNext(1,2,3,4,5)
			.expectComplete()
			.verify(Duration.ofMillis(500));
		
	}
	
	
}
