package java_reactive_demo.sinks;

import java_reactive_demo.util.Util;
import reactor.core.publisher.Mono;
import reactor.core.publisher.Sinks;
import reactor.core.publisher.Sinks.One;

public class S2SinksMonoError {

	public static void main(String[] args) {
		//publisher , subscriber , processor
		
		One<Object> sink = Sinks.one(); // sink handle with publisher
		Mono<Object> mono = sink.asMono(); // mono handle with subscriber
		
		mono.subscribe(Util.subscriber("Dara"));
		//mono.subscribe(Util.subscriber("Thida"));
		//sink.tryEmitEmpty();
		sink.tryEmitError(new RuntimeException("Err"));
		
		//sink.tryEmitValue("Hello");
		//sink.tryEmitValue("How are you");
		
	}

}
