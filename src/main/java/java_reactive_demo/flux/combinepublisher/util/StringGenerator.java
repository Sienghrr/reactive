package java_reactive_demo.flux.combinepublisher.util;

import java_reactive_demo.util.Util;
import reactor.core.publisher.Flux;

import java.util.ArrayList;
import java.util.List;

public class StringGenerator {
	
	List<String> list = new ArrayList<>(List.of("AA","BB"));
	
	public Flux<String> getName(){
		
		return Flux.generate(sink ->{
			
			String name = Util.faker().name().firstName();
			System.out.println("===> Fresh Generated Name: " + name );
			list.add(name);
			Util.sleep(1);
			sink.next(name);
		})
		.cast(String.class) // convert to String
		.startWith(getFromCache()); //combine publisher by using startWith
		
	}
	
	public Flux<String> getFromCache(){
		return Flux.fromIterable(list);
	}

}
