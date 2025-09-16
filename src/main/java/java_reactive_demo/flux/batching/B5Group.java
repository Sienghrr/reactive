package java_reactive_demo.flux.batching;

import java.time.Duration;
import java.util.concurrent.atomic.AtomicInteger;

import java_reactive_demo.util.Util;
import reactor.core.publisher.Flux;
import reactor.core.publisher.GroupedFlux;

public class B5Group {
	private static AtomicInteger atomicInteger = new AtomicInteger(1);

	public static void main(String[] args) {
		
		flux()
			.groupBy(x -> x%2)
			.subscribe(gf -> processItem(gf, gf.key()));
		
		Util.sleep(20);
	}
	
	public static void processItem(Flux<Integer> flux, Integer key) {
		System.out.println("----Called----");
		flux.subscribe(x -> System.out.println("Item: "+ x + " - Key: "+ key));
	}
	
	public static Flux<Integer> flux(){
		return Flux.range(1, 30)
					.delayElements(Duration.ofSeconds(1));
				
	}
	
	
}
