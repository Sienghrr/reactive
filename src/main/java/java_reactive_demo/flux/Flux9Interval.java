package java_reactive_demo.flux;

import java.time.Duration;

import java_reactive_demo.util.Util;
import reactor.core.publisher.Flux;

public class Flux9Interval {

	public static void main(String[] args) {
		
		Flux.interval(Duration.ofSeconds(2))
			.subscribe(x -> System.out.println(x));
		
		Util.sleep(6);
	
	}

}
