package java_reactive_demo.flux;

import reactor.core.publisher.Flux;

public class Flux11FluxToMono {

	public static void main(String[] args) {
		
		
	
		Flux<Integer> flux = Flux.just(7,6,3, 8,9);
		
//		flux
//			.filter(x -> x>7)
//			.next()
//			.subscribe(System.out::println);
		
		flux
		.next()
		.filter(x -> x>5)
		.subscribe(System.out::println);
		
	}
	
	

}
