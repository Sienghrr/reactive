package java_reactive_demo.flux.hotcold.exercise;

import java.time.Duration;
import java.util.Objects;

import reactor.core.publisher.Flux;

public class OrderService {
	
	private Flux<PurchaseOrder> flux;
	
	public Flux<PurchaseOrder> getStreamingOrder(){
		if(Objects.isNull(flux)) {
			flux = getOrders();
		}
		return flux;
	}
	
	private Flux<PurchaseOrder> getOrders(){
		return Flux.interval(Duration.ofMillis(100))
				.map(x -> new PurchaseOrder())
				.share();
	}

}
