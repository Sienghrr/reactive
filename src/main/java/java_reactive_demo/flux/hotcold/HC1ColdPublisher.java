package java_reactive_demo.flux.hotcold;

import java.time.Duration;
import java.util.stream.Stream;

import java_reactive_demo.util.Util;
import reactor.core.publisher.Flux;

public class HC1ColdPublisher {

	public static void main(String[] args) {
		// cold and hot publisher
        // cold-publisher : seperated streaming data (ex: I have account netflix and others also have
        // theirs and example when we watch a movie title A , I can watch anytime and watch from the
        // beginning , and other also)

        // hot-publisher: not seperated (ex: someone livestream start from 5pm, and i join at 5pm
        // so i get full info, and you join at 6pm , you will miss the info from 5-6pm)
		Flux<String> flux = Flux.fromStream(() -> getMovies())
			.delayElements(Duration.ofSeconds(2));
		
		
		flux.subscribe(Util.subscriber("Dara"));
		
		Util.sleep(5);
		
		flux.subscribe(Util.subscriber("Thida"));
		
		Util.sleep(60);
		

	}
	
	private static Stream<String> getMovies(){
		System.out.println("Request streaming video...");
		return Stream.of("scene 1","scene 2","scene 3","scene 4","scene 5","scene 6");
	}

}
