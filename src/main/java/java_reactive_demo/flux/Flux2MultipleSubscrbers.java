package java_reactive_demo.flux;

import java_reactive_demo.util.Util;
import reactor.core.publisher.Flux;

public class Flux2MultipleSubscrbers {

	public static void main(String[] args) {
		Flux<Integer> flux = Flux.just(1,2,3,4);
		//flux.subscribe(x -> System.out.println("Recieved: "+ x));
		
		flux.subscribe(x -> System.out.println("Sub A: "+ x));
		
		flux
			.filter(x -> x % 2 == 0)
			.subscribe(x -> System.out.println("Sub B: "+ x));
		
	}

}
