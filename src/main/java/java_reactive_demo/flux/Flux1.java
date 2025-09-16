package java_reactive_demo.flux;

import java_reactive_demo.util.Util;
import reactor.core.publisher.Flux;

public class Flux1 {

	public static void main(String[] args) {
		Flux<Integer> flux = Flux.just(1,2,3,4);
		//flux.subscribe(x -> System.out.println("Recieved: "+ x));
		flux
			.map(x -> x +"")
			.subscribe(Util.onNext(), Util.onError(), Util.onComplete());
	}

}
