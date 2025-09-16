package java_reactive_demo.flux;

import java.time.Duration;

import java_reactive_demo.util.Util;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class Flux10MonoToFlux {

	public static void main(String[] args) {
		
		
	
		Mono<Integer> mono = Mono.just(3);
		//Flux<Integer> flux = Flux.just(2,6,3);
		Flux<Integer> flux = Flux.from(mono);
		getName(flux);
	}
	
	public static void getName(Flux<Integer> flux) {
		
	}

}
