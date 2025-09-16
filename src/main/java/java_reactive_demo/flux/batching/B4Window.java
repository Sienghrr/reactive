package java_reactive_demo.flux.batching;

import java.time.Duration;
import java.util.concurrent.atomic.AtomicInteger;

import java_reactive_demo.util.Util;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class B4Window {
	private static AtomicInteger atomicInteger = new AtomicInteger(1);

	public static void main(String[] args) {
		
		fluxStream()
			.window(5) // Flux<String>
			//Flux<Flux<String>>
			.flatMap(flux ->saveItems(flux))
			.subscribe(Util.subscriber());
		
		Util.sleep(20);
	}
	
	public static Flux<String> fluxStream(){
		return Flux.interval(Duration.ofMillis(300))
					//.take(4)
					.map(x -> "event-"+x);
	}
	
	public static Mono<Integer> saveItems(Flux<String> flux) {
		return flux
			.doOnNext(x -> System.out.println("Saving : " + x))
			.doOnComplete(() ->System.out.println("Items saved"))
			.then(Mono.just(atomicInteger.getAndIncrement()));
			
	}

}
