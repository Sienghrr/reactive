package java_reactive_demo.flux.operator;

import java_reactive_demo.util.Util;
import reactor.core.publisher.Flux;

public class O1Handle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//handle = filter + map
		/*
		Flux.range(1, 20)
			.handle((number,sink) ->{
				if(number % 2 == 0) {
					sink.next(number);
				}else {
					sink.next(number + "bb");
				}
			})
			.subscribe(Util.subscriber());
			
		*/
		
		
		
		Flux.generate(sink ->{
			sink.next(Util.faker().country().name());
		})
		.map(Object::toString)
		.handle((name, sink) ->{
			System.out.println("Emitting: " + name);
			if(name.toLowerCase().equals("brazil")) {
				sink.complete();
			}else {
				sink.next(name);
			}
		})
		.subscribe(Util.subscriber());

	}

}
