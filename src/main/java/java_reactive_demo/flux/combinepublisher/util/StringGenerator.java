package java_reactive_demo.flux.combinepublisher.util;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import java_reactive_demo.util.Util;
import reactor.core.publisher.Flux;

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
		.cast(String.class)
		.startWith(getFromCache());
		
	}
	
	public Flux<String> getFromCache(){
		return Flux.fromIterable(list);
	}

}
