package java_reactive_demo.flux.operator;

import java.time.Duration;

import java_reactive_demo.util.Util;
import reactor.core.publisher.Flux;
import reactor.util.concurrent.Queues;

public class O4DelayElement {

	public static void main(String[] args) {
		System.setProperty("reactor.bufferSize.x", "10");
		
		Flux.create(sink ->{
			for(int i=1; i<=1000; i++) {
				sink.next(i);
			}
		})
		.log()
		.delayElements(Duration.ofSeconds(1))
		.subscribe(Util.subscriber());
		
		Util.sleep(60);
		
		
		//Queues
		
	}

}
