package java_reactive_demo.flux.operator;

import java.time.Duration;

import java_reactive_demo.util.Util;
import reactor.core.publisher.Flux;

public class O6Timeout {

	public static void main(String[] args) {
		getNumbers()
			.timeout(Duration.ofSeconds(2), fallback())
			.subscribe(Util.subscriber());
		
		Util.sleep(60);
	}
	
	private static Flux<Integer> getNumbers(){
		return Flux.range(1, 10)
				.delayElements(Duration.ofSeconds(1));
	}
	
	private static Flux<Integer> fallback(){
		return Flux.range(200, 100)
				.delayElements(Duration.ofSeconds(1));
	}

}
