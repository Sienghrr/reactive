package java_reactive_demo.flux.combinepublisher;

import java_reactive_demo.util.Util;
import reactor.core.publisher.Flux;

public class CP4Zip {

	public static void main(String[] args) {
		Flux.zip(getBody(),getEngine(),getTires())
			.doOnNext(car ->{
				System.out.println(car.getT1());
			})
			.subscribe(Util.subscriber());
	}
	
	public static Flux<String> getBody(){
		return Flux.just("body1","body2","body3");
	}
	
	public static Flux<String> getEngine(){
		return Flux.just("engineA","engineB");
	}
	
	public static Flux<String> getTires(){
		return Flux.just("tires1","tires2","tires3","tires4");
	}
	
	

}
