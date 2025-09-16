package java_reactive_demo.flux.thread;

import reactor.core.publisher.Flux;

public class TS1DefaultThread {

	public static void main(String[] args) {
		Flux<Object> flux = Flux.create(sink ->{
			printThreadName("create");
			sink.next(10);
		})
		.doOnNext(x -> printThreadName("next: " + x));
		
		//flux.subscribe(x -> printThreadName("sub: " + x));
		
		Runnable runnable = () -> flux.subscribe(x -> printThreadName("sub: " + x));
		
		for(int i=0; i<2; i++) {
			new Thread(runnable).start();
		}
		
		
	}
	
	private static void printThreadName(String text) {
		System.out.println(text+ " - Thread: "+ Thread.currentThread().getName());
	}

}
