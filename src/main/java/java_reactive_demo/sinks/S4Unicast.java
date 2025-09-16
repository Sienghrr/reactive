package java_reactive_demo.sinks;

import java_reactive_demo.util.Util;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.publisher.Sinks;
import reactor.core.publisher.Sinks.Many;
import reactor.core.publisher.Sinks.One;
import reactor.core.publisher.Sinks.UnicastSpec;

public class S4Unicast {

	public static void main(String[] args) {
		
	// sink = publisher	
	Many<Object> sink = Sinks.many().unicast().onBackpressureBuffer();
	// flux use by subscriber
	Flux<Object> flux = sink.asFlux();
	
	flux.subscribe(Util.subscriber("Dara"));
	flux.subscribe(Util.subscriber("Rith"));
	
	sink.tryEmitNext("Hello");
	sink.tryEmitNext("How are you");
	
	
	
	
		
	}

}
