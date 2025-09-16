package java_reactive_demo.flux.operator;

import java_reactive_demo.util.Util;
import reactor.core.publisher.Flux;

public class O2DoHook {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Flux.range(1, 20)
			/*.map(x -> {
				Integer num = Util.faker().random().nextInt(0, 10);
				if(num > 5) {
					throw new RuntimeException("--- Error---");
				}
				return x;
			})*/
			.doOnCancel(() -> System.out.println("doOnCancel"))
			.doOnComplete(() -> System.out.println("doOnComplete"))
			.doFirst(() -> System.out.println("doFirst 1"))
			.doOnDiscard(Object.class, x -> System.out.println("doOnDiscard: "+ x))
			.doOnError(e -> System.out.println("doOnError: " + e.getMessage()))
			.doOnNext(x -> System.out.println("doOnNext:" + x))
			.doOnSubscribe(s -> System.out.println("doOnSubscribe 1: " + s))
			.doFinally(signal -> System.out.println("doFinally: " + signal))
			.doFirst(() -> System.out.println("doFirst 2"))
			.doOnRequest(l -> System.out.println("doOnRequest: "+ l))
			.doOnSubscribe(s -> System.out.println("doOnSubscribe 2: " + s))
			.doFirst(() -> System.out.println("doFirst 3"))
			.doOnTerminate(() -> System.out.println("doOnTerminate"))
			.take(3)
			.doFinally(signal -> System.out.println("doFinally 2: " + signal))
			.subscribe(Util.subscriber());
			

	}

}
