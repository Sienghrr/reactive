package java_reactive_demo.flux.hotcold;

import java.time.Duration;
import java.util.stream.Stream;

import java_reactive_demo.util.Util;
import reactor.core.publisher.Flux;

public class HC6ublishAutoConnectNoSubscriberToStart {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// share() = publish().refCount(1)
		Flux<String> flux = Flux.fromStream(() -> getMovies())
			.delayElements(Duration.ofSeconds(1))
			.publish()
			.autoConnect(0);
		
		Util.sleep(3);
		flux.subscribe(Util.subscriber("Dara"));
		
		Util.sleep(3);
		System.out.println("Thida is about to join...");
		flux.subscribe(Util.subscriber("Thida"));
		
		Util.sleep(60);
		

	}
	
	private static Stream<String> getMovies(){
		System.out.println("Request streaming video...");
		return Stream.of("scene 1","scene 2","scene 3","scene 4","scene 5","scene 6");
	}

}
