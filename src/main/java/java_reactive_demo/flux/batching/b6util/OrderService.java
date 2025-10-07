package java_reactive_demo.flux.batching.b6util;

import java.time.Duration;

import reactor.core.publisher.Flux;

public class OrderService {

	public Flux<PurchaseOrder> orderFlux(){
		return Flux.interval(Duration.ofMillis(100))
				.map(x -> new PurchaseOrder());
	}
}
