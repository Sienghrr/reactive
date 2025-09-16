package java_reactive_demo.flux.emit;

import java_reactive_demo.util.Util;
import reactor.core.publisher.Flux;

public class E4TakeOperator {

	public static void main(String[] args) {
		/*
		Flux.range(1, 10)
			.log()
			.take(3) // cancel
			.log()
			.subscribe(Util.subscriber());
		
		*/
		
		Flux.create(fluxSink ->{
			String color ="";
			
			
			do {
				color = Util.faker().color().name();
				System.out.println("Emiting: " + color);
				fluxSink.next(color);
			}while(!color.toLowerCase().equals("yellow") && !fluxSink.isCancelled());
			
			fluxSink.complete();
		})
			//.log()
			.take(3)
			//.log()
			.subscribe(Util.subscriber());
		
	}

}
