package java_reactive_demo.flux.combinepublisher;

import java.time.Duration;

import java_reactive_demo.util.Util;
import reactor.core.publisher.Flux;

public class CP5CombineLatest {

	public static void main(String[] args) {
		Flux.combineLatest(stringStream(), intergerStream(), (s,i) -> s+i)
			.subscribe(Util.subscriber())
			;
		
		Util.sleep(20);
	}
	
	private static Flux<String> stringStream(){
		return Flux.just("A","B","C","D")
				.delayElements(Duration.ofSeconds(1))
				.doOnNext(x -> System.out.println("String => "+x));
				
	}
	
	private static Flux<Integer> intergerStream(){
		return Flux.just(1,2,3,4,5,6)
				
				.delayElements(Duration.ofSeconds(3))
				.doOnNext(x -> System.out.println("Integer=> "+x));
				
	}
	
	

}
