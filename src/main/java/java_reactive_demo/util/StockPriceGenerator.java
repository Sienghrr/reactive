package java_reactive_demo.util;

import java.time.Duration;
import java.util.concurrent.atomic.AtomicInteger;

import reactor.core.publisher.Flux;

public class StockPriceGenerator {
	private AtomicInteger atomicInteger = new AtomicInteger(100);
	
	public Flux<Integer> getPrice(){
		return Flux.interval(Duration.ofSeconds(1))
			.map(x -> atomicInteger.accumulateAndGet(
					Util.faker().random().nextInt(-3, 3), 
					(a,b) -> a + b));
	}

}
