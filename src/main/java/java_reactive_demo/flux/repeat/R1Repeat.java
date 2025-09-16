package java_reactive_demo.flux.repeat;

import java.util.concurrent.atomic.AtomicInteger;

import java_reactive_demo.util.Util;
import reactor.core.publisher.Flux;

public class R1Repeat {
	
	private static AtomicInteger atomicInteger = new AtomicInteger(1);

	public static void main(String[] args) {
		flux()
			.repeat(2)
			.subscribe(Util.subscriber());
	}
	
	public static Flux<Integer> flux(){
		return Flux.range(1, 3)
				.doOnSubscribe(x -> System.out.println("---> Subscribe"))
				.doOnComplete(() -> System.out.println("---> Complete"))
				.map(x -> atomicInteger.getAndIncrement())
				;
				
	}

}
