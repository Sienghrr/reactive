package java_reactive_demo.flux.operator;

import java.time.Duration;

import java_reactive_demo.util.Util;
import reactor.core.publisher.Flux;

public class O7DefaultIfEmpty {

	public static void main(String[] args) {
		getNumbers()
			.filter(x -> x>8)
			.defaultIfEmpty(100)
			.subscribe(Util.subscriber());
	}
	
	private static Flux<Integer> getNumbers(){
		return Flux.range(1, 10);
	}

}
