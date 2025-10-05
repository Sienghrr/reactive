package java_reactive_demo;

import org.reactivestreams.Subscription;
import reactor.core.Disposable;
import reactor.core.publisher.Mono;
import reactor.util.context.Context;

import java.util.function.Consumer;

public class Demo1 {

    /**
     * In concept reactive it is about Publisher and Subscriber.
     * And When subscriber have subscribed publisher , subscriber will get the data that produce by publisher through
     * Subscription(act as a bridge)
     *
     * When publisher , example have 10 item it will emit to subscriber by invoking
     * method onSubscribe(automatically invoke when subscribe to publisher),
     * And we want to deliver item to subscriber one by one we need to invoke method onNext(),
     * And when have no item to emit to subscriber , we are invoking method onComplete(),
     * Last , invoking method onError to handle error occur.
     *
     * In java reactive , we have two publisher : Mono and Flux
     * Mono: 0->1 item,
     * Flux: 0->N item
     *
     *
     * The behavior of Publisher is lazy processing , it won't execute , it is executing only if we subscribe to it.
     */
	public static void main(String[] args) {

		Mono<String> mono = Mono.just("Dara");
        // if we do not subscribe here , when we are trying to print , we just see message MonoJust , not value we want
		// mono.subscribe(x -> System.out.println(x));
		// System.out.println(mono);
		
		mono.subscribe(
				x -> System.out.println("onNext:"+x),
				ex -> System.out.println("onError: " + ex.getMessage()),
				() -> System.out.println("onComplete: Done."));
		
		
	}

}
