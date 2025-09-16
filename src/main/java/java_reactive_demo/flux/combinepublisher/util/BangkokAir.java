package java_reactive_demo.flux.combinepublisher.util;

import java.time.Duration;

import java_reactive_demo.util.Util;
import reactor.core.publisher.Flux;

public class BangkokAir {
	
	public static  Flux<String> getFlight(){
		return Flux.range(1, Util.faker().random().nextInt(1,6))
				.map(x -> "BangkokAir: " + Util.faker().random().nextInt(600,900))
				.delayElements(Duration.ofSeconds(1))
				.filter(x -> Util.faker().random().nextBoolean());
	}

}
