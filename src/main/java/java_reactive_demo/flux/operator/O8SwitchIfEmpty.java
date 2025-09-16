package java_reactive_demo.flux.operator;

import java_reactive_demo.util.Util;
import reactor.core.publisher.Flux;

public class O8SwitchIfEmpty {

	public static void main(String[] args) {
		getNumbers()
			.filter(x -> x>10)
			//.defaultIfEmpty(100)
			.switchIfEmpty(getNewNumbers())
			.subscribe(Util.subscriber());
	}
	
	private static Flux<Integer> getNumbers(){
		return Flux.range(1, 10);
	}
	
	private static Flux<Integer> getNewNumbers(){
		return Flux.range(555, 10);
	}

}
