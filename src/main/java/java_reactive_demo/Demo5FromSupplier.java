package java_reactive_demo;

import java.util.Optional;
import java.util.stream.Stream;

import com.github.javafaker.Faker;

import java_reactive_demo.util.Util;
import reactor.core.publisher.Mono;

public class Demo5FromSupplier {

	public static void main(String[] args) {
		

		// we use just method only when we already have data
		// Mono<String> mono = Mono.just(getName());

        //fromSupplier only work when have subscriber
		Mono<String> mono = Mono.fromSupplier(() -> getName());
		//mono.subscribe(Util.onNext(), Util.onError(),Util.onComplete());
		

		String optional = Stream.of("test","dfads")
			.filter(x -> x.startsWith("d"))
			.findFirst()
			.orElseGet(() -> "Not found");
		
		System.out.println(optional);
		
		
	}
	
	private static String getName() {
		System.out.println("Generating name ...");
		return Faker.instance().funnyName().name();
	}

}
