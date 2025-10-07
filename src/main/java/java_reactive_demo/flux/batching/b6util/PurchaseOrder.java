package java_reactive_demo.flux.batching.b6util;

import java_reactive_demo.util.Util;
import lombok.Data;

@Data
public class PurchaseOrder {
	private String productName;
	private Double price;
	private String category;

	
	public PurchaseOrder() {
		this.productName = Util.faker().commerce().productName();
		this.price = Double.parseDouble(Util.faker().commerce().price());
		category = Util.faker().commerce().department();
	}
}
