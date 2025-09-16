package java_reactive_demo;

import java_reactive_demo.util.Util;
import reactor.core.publisher.Mono;

public class Demo3AddUtil {

	public static void main(String[] args) {
		
		Mono<String> mono = Mono
					.just("Thida")
					.map(String::toUpperCase);
		
		mono.subscribe(Util.onNext(), Util.onError(),Util.onComplete());
		
		
	}

}
