package java_reactive_demo.flux.thread;

import java_reactive_demo.util.Util;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

public class TS3MultiSubscribeOn {

	public static void main(String[] args) {
		Flux<Object> flux = Flux.create(sink ->{
			printThreadName("create");
			sink.next(10);
		})
        // and the thread that are closer to the publisher is the one that use to process data
        // in these case thread sieng is closer than boundedElastic , so thread sieng will be the one who
        // process data
		.subscribeOn(Schedulers.newParallel("sieng"))// use parallel for cpu intensive task
		.doOnNext(x -> printThreadName("next: " + x));
		
		flux
			.doFirst(() -> printThreadName("doFirst2:"))
			.subscribeOn(Schedulers.boundedElastic()) // use boundedElastic when in case network/time-consuming (ex: retrieve data from db)
			.doFirst(() -> printThreadName("doFirst1:"))
			.subscribe(x -> printThreadName("sub: " + x));
		
		
		
		/*
		Runnable runnable = () -> flux
				.doFirst(() -> printThreadName("doFirst2:"))
				.subscribeOn(Schedulers.boundedElastic())
				.doFirst(() -> printThreadName("doFirst1:"))
				.subscribe(x -> printThreadName("sub: " + x));
		
		for(int i=0; i<2; i++) {
			new Thread(runnable).start();
		}
		*/
		Util.sleep(60);
	}
	
	private static void printThreadName(String text) {
		System.out.println(text+ " - Thread: "+ Thread.currentThread().getName());
	}

}
