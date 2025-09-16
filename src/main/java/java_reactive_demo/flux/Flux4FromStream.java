package java_reactive_demo.flux;

import java.util.List;
import java.util.stream.Stream;

import reactor.core.publisher.Flux;

public class Flux4FromStream {

	public static void main(String[] args) {
		
		List<Integer> list = List.of(5,6,7,8);
		Stream<Integer> stream = list.stream();
		
		//stream.forEach(x -> System.out.println(x));
		//stream.forEach(x -> System.out.println(x));
		
		//Flux<Integer> flux = Flux.fromStream(stream);
		Flux<Integer> flux = Flux.fromStream(() -> list.stream());
		flux.subscribe(x -> System.out.println("Recieved A: "+ x));
		flux.subscribe(x -> System.out.println("Recieved B: "+ x));
		
		
	}

}
