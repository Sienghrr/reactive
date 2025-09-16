package java_reactive_demo.flux.emit;

import java.util.concurrent.atomic.AtomicInteger;

import java_reactive_demo.util.Util;
import reactor.core.publisher.Flux;
import reactor.core.publisher.SynchronousSink;

public class E5Generate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		Flux.create(fluxSink ->{
			fluxSink.next(23);
			fluxSink.next(45);
			fluxSink.next(24);
		})
		.subscribe(Util.subscriber());
		*/
		/*
		Flux.generate(synchronousSink  ->{
			//synchronousSink.next("Dara");
			//synchronousSink.next("Thida");
			//synchronousSink.complete();
			//synchronousSink.error(new RuntimeException("Something wrong!!"));
			String name = Util.faker().country().name();
			System.out.println("Emitting: "+ name);
			if(name.toLowerCase().equals("brazil")) {
				synchronousSink.complete();
			}else {
				synchronousSink.next(name);
			}
			
			
			
		})
		.subscribe(Util.subscriber());
		*/
		
		// Emit only 10 item
		//final int counter = 0;
		AtomicInteger atomicInteger = new AtomicInteger(0);
		//atomicInteger.incrementAndGet();
		//atomicInteger.incrementAndGet();
		
		/*
		Flux.generate(synchronousSink  ->{
			String name = Util.faker().country().name();
			System.out.println("Emitting: "+ name);
			//counter = counter + 1;
			atomicInteger.incrementAndGet();
			if(atomicInteger.get() > 10) {
				synchronousSink.complete();
			}else {
				synchronousSink.next(name);
				
			}
		})
		.subscribe(Util.subscriber());
		
		*/
		
		// consumer : receive 1 parameter then consume
		// callable : no parameter / no input
		
		Flux.generate(() -> 1, (counter, sink) ->{
			String name = Util.faker().country().name();
			sink.next(name);
			if(counter == 10) {
				sink.complete();
			}
			return counter + 1;
		})
		.subscribe(Util.subscriber());
		
		
	}

}
