package java_reactive_demo.flux.hotcold.exercise;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

import reactor.core.publisher.Flux;

public class InventoryService {
	
	private Map<String, Integer> db = new HashMap<>();
	
	public InventoryService() {
		db.put("Kids", 100);
		db.put("Clothing", 100);
	}
	
	public Consumer<PurchaseOrder> consumeOrderStreaming(){
		return p -> db.computeIfPresent(p.getCategory(), (k,v) -> v - p.getQty());
	}
	
	public Flux<String> getInventory(){
		return Flux.interval(Duration.ofSeconds(2))
			.map(x -> db.toString());
	}
	
	
	

}
