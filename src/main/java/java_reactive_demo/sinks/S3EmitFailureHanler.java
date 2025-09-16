package java_reactive_demo.sinks;

import java_reactive_demo.util.Util;
import reactor.core.publisher.Mono;
import reactor.core.publisher.Sinks;
import reactor.core.publisher.Sinks.EmitFailureHandler;
import reactor.core.publisher.Sinks.One;

public class S3EmitFailureHanler {

	public static void main(String[] args) {
		//publisher , subscriber , processor
		
		One<Object> sink = Sinks.one(); // sink handle with publisher
		Mono<Object> mono = sink.asMono(); // mono handle with subscriber
		
		mono.subscribe(Util.subscriber("Dara"));
		
		sink.tryEmitValue("Hey");
		
		sink.emitValue("Hello Sunday", (signalType, emitResult) ->{
			System.out.println(signalType.name());
			System.out.println(emitResult.name());
			return true;
		});
		
		//EmitFailureHandler
		
		
	}

}
