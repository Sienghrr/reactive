package java_reactive_demo.flux.emit;

import java_reactive_demo.util.DefaultSubscriber;
import java_reactive_demo.util.Util;
import reactor.core.publisher.Flux;

public class E1CustomSubcriber {
	
	public static void main(String[] args) {
		Flux.range(1, 10)
			//.map(x -> Util.faker().country().name())
			//.subscribe(Util.onNext(), Util.onError(), Util.onComplete());
			.subscribe(new DefaultSubscriber());
		
		
		Flux<Integer> flux = Flux.range(1, 10);
		flux.subscribe(new DefaultSubscriber("S1"));
		
		flux.subscribe(Util.subscriber());
		
		
	}

}
