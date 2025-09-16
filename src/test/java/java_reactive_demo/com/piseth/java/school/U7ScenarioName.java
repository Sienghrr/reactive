package java_reactive_demo.com.piseth.java.school;

import org.junit.jupiter.api.Test;

import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;
import reactor.test.StepVerifierOptions;

public class U7ScenarioName {
	
	private Flux<Integer> getItems(){
		return Flux.range(1, 3);
	}
	
	@Test
	public void testFlux() {
		var options = StepVerifierOptions.create().scenarioName("Test item from 1 to 3");
		StepVerifier.create(getItems(), options)
			.expectNext(15).as("First item should be 15")
			.expectNext(2,3).as("then should be 2,3")
			.expectComplete()
			.verify();
		
	}
	
	
}
