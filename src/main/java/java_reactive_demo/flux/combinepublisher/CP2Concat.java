package java_reactive_demo.flux.combinepublisher;

import java_reactive_demo.util.Util;
import reactor.core.publisher.Flux;

public class CP2Concat {

	public static void main(String[] args) {
		
		Flux<String> flux1 = Flux.just("a","b");
		Flux<String> flux2 = Flux.just("e","f","g");
		Flux<String> flux3 = Flux.error(new RuntimeException("Something's wrong"));
		
		//Flux<String> flux = flux1.concatWith(flux2);
		Flux<String> flux = Flux
				.concatDelayError(flux1,flux3, flux2);
		flux.subscribe(Util.subscriber());
		
		
			
		
	}

}
