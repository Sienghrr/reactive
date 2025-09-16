package java_reactive_demo.flux;

import java_reactive_demo.util.Util;
import reactor.core.publisher.Flux;

public class Flux6Log {

	public static void main(String[] args) {
		
		Flux<Integer> flux = Flux.range(5, 6);
		flux
			.log()
			.map(i -> Util.faker().country().name())
			.log()
			.subscribe(x -> System.out.println(x));
		
		
	}

}
