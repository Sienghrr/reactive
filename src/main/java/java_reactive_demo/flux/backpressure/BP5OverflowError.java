package java_reactive_demo.flux.backpressure;

import java_reactive_demo.util.Util;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

public class BP5OverflowError {
	// 75% of 16 = 12
	//69 -> 80
	public static void main(String[] args) {
		System.setProperty("reactor.bufferSize.small", "16");
		
		Flux.create(sink ->{
			for(int i=1; i<501 && !sink.isCancelled(); i++) {
                //!sink.isCancelled()
                // we add extra condition , cuz we want our publisher to stop producing
                // when facing error
				System.out.println("Pushed: " + i);
				sink.next(i);
				Util.sleepMili(1);
			}
			sink.complete();
		})
		.onBackpressureError()
		.publishOn(Schedulers.boundedElastic())
		.doOnNext(x ->{
			Util.sleepMili(10);
		})
		.subscribe(Util.subscriber());
		
		
		Util.sleep(10);
	}

}
