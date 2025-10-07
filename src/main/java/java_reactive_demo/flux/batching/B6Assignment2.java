package java_reactive_demo.flux.batching;

import java.util.Map;
import java.util.Set;
import java.util.function.Function;

import java_reactive_demo.flux.batching.b6util.OrderProcess;
import java_reactive_demo.flux.batching.b6util.OrderService;
import java_reactive_demo.flux.batching.b6util.PurchaseOrder;
import java_reactive_demo.util.Util;
import reactor.core.publisher.Flux;

public class B6Assignment2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		for(int i=1; i<50; i++) {
			String category =  Util.faker().commerce().department();
			System.out.println(category);
		}
		*/
		// Kids, Sports
		OrderProcess orderProcess = new OrderProcess();
		
		Map<String, Function<Flux<PurchaseOrder>, Flux<PurchaseOrder>>> map = Map.of(
				"Kids",orderProcess.kidsProcessing(),
				"Sports", orderProcess.sportsProcessing()
				
		);
		
		//Set<String> set = Set.of("Kids","Sports");
		Set<String> set = map.keySet();
		
		OrderService orderService = new OrderService();
		orderService
			.orderFlux()
			.filter(p -> set.contains(p.getCategory()))
			.groupBy(p -> p.getCategory())
			.flatMap(gf -> map.get(gf.key()).apply(gf))
			.subscribe(Util.subscriber());
		
		Util.sleep(30);

	}

}
