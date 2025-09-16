package java_reactive_demo;

import reactor.core.publisher.Mono;

public class Demo1 {

	public static void main(String[] args) {
		//Mono: 0->1 item
		//Flux: 0->N
		
		Mono<String> mono = Mono.just("Dara");
		//mono.subscribe(x -> System.out.println(x));
		
		//System.out.println(mono);
		
		mono.subscribe(
				x -> System.out.println("onNext:"+x), 
				x -> System.out.println("onError: " + x.getMessage()), 
				() -> System.out.println("onCompelete: Done."));
		
		
	}

}
