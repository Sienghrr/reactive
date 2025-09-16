package java_reactive_demo.flux.batching;

import java.time.Duration;

import java_reactive_demo.util.Util;
import reactor.core.publisher.Flux;

public class B2OverlappingAndDropping {

	public static void main(String[] args) {
		
		fluxStream()
			.buffer(1,10)
			.subscribe(Util.subscriber());
		
		Util.sleep(20);
	}
	
	public static Flux<String> fluxStream(){
		return Flux.interval(Duration.ofMillis(300))
					.map(x -> "event-"+x);
	}

}
