package java_reactive_demo.flux.hotcold.exercise;

import java_reactive_demo.util.Util;
import lombok.Data;

@Data
public class PurchaseOrder {
	private String productName;
	private Double price;
	private int qty;
	private String category;

	
	public PurchaseOrder() {
		this.productName = Util.faker().commerce().productName();
		this.price = Double.parseDouble(Util.faker().commerce().price());
		this.qty = Util.faker().random().nextInt(1, 10);
		category = Util.faker().commerce().department();
	}
}
