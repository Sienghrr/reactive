package java_reactive_demo.flux.operator;

import java_reactive_demo.util.Util;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class O5OnError {

	public static void main(String[] args) {
		/*
		Flux.range(1, 10)
			.map(x -> 20/(6-x))
			.onErrorReturn(-1)
			.subscribe(Util.subscriber());
			
		*/
		
		/*
		Flux.range(1, 10)
		.map(x -> 20/(6-x))
		.onErrorResume(e -> getFallback())
		.subscribe(Util.subscriber());
		*/
		
		Flux.range(1, 10)
		.map(x -> 20/(6-x))
		.onErrorContinue((e,obj) ->{
			System.out.println("Error:" + obj + " Root cause: "+ e.getMessage());
		})
		.subscribe(Util.subscriber());
	}
	
	private static Mono<Integer> getFallback(){
		return Mono.fromSupplier(() -> Util.faker().random().nextInt(100, 200));
	}
	

}
