package java_reactive_demo.flux.batching;

import java.util.function.Function;

import reactor.core.publisher.Flux;

public class OrderProcess {
	
	public Function<Flux<PurchaseOrder>, Flux<PurchaseOrder>> sportsProcessing(){
		return flux ->{
			return flux
					.doOnNext(p -> p.setPrice(1.1 * p.getPrice()))
					.doOnNext(p -> p.setProductName("[[" + p.getProductName() + "]]"))
					;
		};
	}
	
	public Function<Flux<PurchaseOrder>, Flux<PurchaseOrder>> kidsProcessing(){
		return flux ->{
			return flux
					.doOnNext(p -> p.setPrice(0.5 * p.getPrice()))
					.doOnNext(p -> p.setProductName("[[" + p.getProductName() + "]]"))
					.flatMap(p -> Flux.just(p, getFreePurchaseOrder()))
					;
		};
	}
	
	public PurchaseOrder getFreePurchaseOrder() {
		PurchaseOrder order = new PurchaseOrder();
		order.setPrice(0d);
		order.setProductName("FREE-" + order.getProductName());
		return order;
	}

}
