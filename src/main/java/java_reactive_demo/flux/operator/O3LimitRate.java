package java_reactive_demo.flux.operator;

import java_reactive_demo.util.Util;
import reactor.core.publisher.Flux;

public class O3LimitRate {

	public static void main(String[] args) {
		Flux.create(sink ->{
			for(int i=1; i<=1000; i++) {
				sink.next(i);
			}
		})
		.log()
		.limitRate(100, 0) // 75 +75
		.subscribe(Util.subscriber());
		
	}

}
