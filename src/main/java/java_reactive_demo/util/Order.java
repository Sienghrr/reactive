package java_reactive_demo.util;

import lombok.Data;

@Data
public class Order {
	private int userId;
	private String productName;
	private String price;
	
	public Order(int userId) {
		this.userId = userId;
		this.productName = Util.faker().commerce().productName();
		this.price = Util.faker().commerce().price();
	}
}
