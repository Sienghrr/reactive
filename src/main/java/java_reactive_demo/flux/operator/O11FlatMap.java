package java_reactive_demo.flux.operator;

import java_reactive_demo.util.OrderService;
import java_reactive_demo.util.UserService;
import java_reactive_demo.util.Util;

public class O11FlatMap {

	public static void main(String[] args) {
		//Flux<integer> 10 item
		// each item => Flux of 5 object 
		//Flux<Flux<object>>
		
		// Flux<Object> 50 item
		
		
		// user(id,name) -> order(userId,productName,price)
		
		UserService userService = new UserService();
		OrderService orderService = new OrderService();
		
		userService.getUser()
			.flatMap(user -> orderService.getOrder(user.getId()))
			.subscribe(Util.subscriber());
		
		Util.sleep(60);
		
	}

}
