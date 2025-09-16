package java_reactive_demo.sinks;

import java.time.Duration;

import java_reactive_demo.util.Util;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.publisher.Sinks;
import reactor.core.publisher.Sinks.Many;
import reactor.core.publisher.Sinks.One;
import reactor.core.publisher.Sinks.UnicastSpec;

public class S8BestEffort {

	public static void main(String[] args) {
		
	// sink = publisher	
	Many<Object> sink = Sinks.many().multicast().directBestEffort();
	// flux use by subscriber
	Flux<Object> flux = sink.asFlux();
	
	flux.subscribe(Util.subscriber("Dara"));
	flux.delayElements(Duration.ofMillis(100)).subscribe(Util.subscriber("Rith"));
	
	for(int i=0; i<100; i++) {
		sink.tryEmitNext(i);
	}
	
	Util.sleep(10);
		
	}

}
