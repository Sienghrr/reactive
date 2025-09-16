package java_reactive_demo.flux.batching;

import java.time.Duration;

import java_reactive_demo.util.Util;
import reactor.core.publisher.Flux;

public class B1Buffer {

	public static void main(String[] args) {
		
		fluxStream()
			//.buffer(5)
			//.buffer(Duration.ofSeconds(2))
			.bufferTimeout(5, Duration.ofSeconds(2))
			.subscribe(Util.subscriber());
		
		Util.sleep(20);
	}
	
	public static Flux<String> fluxStream(){
		return Flux.interval(Duration.ofMillis(800))
					//.take(4)
					.map(x -> "event-"+x);
	}

}
