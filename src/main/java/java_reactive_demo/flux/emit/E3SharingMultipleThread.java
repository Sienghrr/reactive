package java_reactive_demo.flux.emit;

import java_reactive_demo.util.ColorProducer;
import java_reactive_demo.util.Util;
import reactor.core.publisher.Flux;

public class E3SharingMultipleThread {

	public static void main(String[] args) {
		
		ColorProducer colorProducer = new ColorProducer();
		
	
		
		Flux.create(colorProducer)
			.subscribe(Util.subscriber("S1"));
		
		
		colorProducer.produce();
		
		Runnable runnable = () -> colorProducer.produce();
		
		
		for(int i =0; i<=10; i++) {
			Thread thread = new Thread(runnable);
			thread.start();
		}
		
		
		
	}

}
