package java_reactive_demo.flux.emit;

import java_reactive_demo.util.ColorProducer;
import java_reactive_demo.util.Util;
import reactor.core.publisher.Flux;

public class E2Create {

	public static void main(String[] args) {
		/*
		Flux.create(fluxSink ->{
			fluxSink.next(1);
			fluxSink.next(3);
		}).subscribe(Util.subscriber());
		*/
		/*
		Flux.create(fluxSink ->{
			String color = Util.faker().color().name();
			fluxSink.next(color);
			
			fluxSink.complete();
			
		}).subscribe(Util.subscriber());
		*/
		
		/*
		Flux.create(fluxSink ->{
			String color;
			
			
			do {
				color = Util.faker().color().name();
				fluxSink.next(color);
			}while(!color.toLowerCase().equals("yellow"));
			
			fluxSink.complete();
		}).subscribe(Util.subscriber());
		*/
		
		ColorProducer colorProducer = new ColorProducer();
		
		/*
		
		Flux.create(colorProducer)
			.subscribe(Util.subscriber("S1"));
		
		Flux.create(colorProducer)
		.subscribe(Util.subscriber("S2"));
		*/
		
		//colorProducer.produce();
		Flux<String> flux = Flux.create(colorProducer);
		
		flux.subscribe(Util.subscriber("S1"));
		//flux.subscribe(Util.subscriber("S2"));
		
		colorProducer.produce();
		colorProducer.produce();
		
		
		/*
		for(int i =0; i<=5; i++) {
			colorProducer.produce();
		}
		*/
		
		
	}

}
