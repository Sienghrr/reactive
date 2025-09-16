package java_reactive_demo.sinks;

import java_reactive_demo.util.Util;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.publisher.Sinks;
import reactor.core.publisher.Sinks.Many;
import reactor.core.publisher.Sinks.One;
import reactor.core.publisher.Sinks.UnicastSpec;

public class S9Replay {

	public static void main(String[] args) {
		
	// sink = publisher	
	Many<Object> sink = Sinks.many().replay().all();
	// flux use by subscriber
	Flux<Object> flux = sink.asFlux();
	
	sink.tryEmitNext("Hello");
	sink.tryEmitNext("How are you");
	
	flux.subscribe(Util.subscriber("Dara"));
	flux.subscribe(Util.subscriber("Rith"));
	
	sink.tryEmitNext("?");
	flux.subscribe(Util.subscriber("Thida"));
	sink.tryEmitNext("new message");
	
	
	
	
	
		
	}

}
