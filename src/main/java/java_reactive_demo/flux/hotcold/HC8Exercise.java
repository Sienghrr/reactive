package java_reactive_demo.flux.hotcold;

import java_reactive_demo.flux.hotcold.exercise.InventoryService;
import java_reactive_demo.flux.hotcold.exercise.OrderService;
import java_reactive_demo.flux.hotcold.exercise.RevenueService;
import java_reactive_demo.util.Util;

public class HC8Exercise {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		for(int i=0; i<20; i++) {
			String n = Util.faker().commerce().department();
			System.out.println(n);
		}
		*/
		
		OrderService orderService = new OrderService();
		RevenueService revenueService = new RevenueService();
		InventoryService inventoryService = new InventoryService();
		
		orderService.getStreamingOrder()
			.subscribe(revenueService.consumeOrderStreaming());
		
		orderService.getStreamingOrder()
		.subscribe(inventoryService.consumeOrderStreaming());
		
		revenueService.getRevenue()
			.subscribe(Util.subscriber("Revenue"));
		
		inventoryService.getInventory()
		.subscribe(Util.subscriber("Inventory"));
		
		Util.sleep(60);
				
	}

}
