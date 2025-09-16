package java_reactive_demo.com.piseth.java.school;

import java.time.Duration;

import org.junit.jupiter.api.Test;

import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

public class U6VirtualTimeTest {
	
	private Flux<Integer> getItems(){
		return Flux.range(1, 5)
					.delayElements(Duration.ofSeconds(10));
	}
	
	@Test
	public void testFlux() {
		//StepVerifier.create(getItems())
		//StepVerifier.withVirtualTime(() -> getItems())
		StepVerifier.withVirtualTime(this::getItems)
			.thenAwait(Duration.ofSeconds(51))
			.expectNext(1,2,3,4,5)
			.expectComplete()
			.verify();
		
	}
	
	@Test
	public void testFlux2() {
		StepVerifier.withVirtualTime(this::getItems)
			.expectSubscription()
			.expectNoEvent(Duration.ofSeconds(9))
			.thenAwait(Duration.ofSeconds(20))
			.expectNext(1,2)
			.thenAwait(Duration.ofSeconds(30))
			.expectNext(3,4,5)
			.expectComplete()
			.verify();
		
	}
	
	
}
