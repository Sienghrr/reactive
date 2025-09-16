package java_reactive_demo.flux.backpressure;

import java_reactive_demo.util.Util;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

public class BP1OverflowDemo {

	public static void main(String[] args) {
		Flux.create(sink ->{
			for(int i=1; i<501; i++) {
				System.out.println("Pushed: " + i);
				sink.next(i);
			}
			sink.complete();
		})
		.publishOn(Schedulers.boundedElastic())
		.doOnNext(x ->{
			Util.sleepMili(10);
		})
		.subscribe(Util.subscriber());
		
		
		Util.sleep(60);
	}

}
