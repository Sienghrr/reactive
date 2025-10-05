package java_reactive_demo.flux.backpressure;

import java_reactive_demo.util.Util;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

/*
OverFlow Strategy:
- buffer : keep in memory
- drop   : once the queue is full, new items will be dropped
- latest : once the queue is full, keep one latest item, drop old.
- error  : throws error to the downstream

purpose : use when publisher produce item faster than consumer can consume , we need OverFlow Strategy
to prevent out of memory error or stuck system.
* */
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
