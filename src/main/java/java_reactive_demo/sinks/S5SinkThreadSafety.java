package java_reactive_demo.sinks;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import java_reactive_demo.util.Util;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.publisher.Sinks;
import reactor.core.publisher.Sinks.Many;
import reactor.core.publisher.Sinks.One;
import reactor.core.publisher.Sinks.UnicastSpec;

public class S5SinkThreadSafety {

	public static void main(String[] args) {
		
	// sink = publisher	
	Many<Object> sink = Sinks.many().unicast().onBackpressureBuffer();
	// flux use by subscriber
	Flux<Object> flux = sink.asFlux();
	
	List<Object> list = new ArrayList<>();
	//flux.subscribe(Util.subscriber("Dara"));
	//flux.subscribe(x -> System.out.println(x));
	//flux.subscribe(x -> list.add(x));
	flux.subscribe(list::add);
	
	
	
	for(int i=0; i<100; i++) {
		int j = i;
		CompletableFuture.runAsync(() ->{
			//sink.tryEmitNext(j);
			sink.emitNext(j, (s,e) -> true);
		});
	}
	
	Util.sleep(4);
	System.out.println(list.size());
	
	
	
		
	}

}
