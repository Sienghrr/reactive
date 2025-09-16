package java_reactive_demo.flux.combinepublisher;

import java_reactive_demo.flux.combinepublisher.util.AirAsia;
import java_reactive_demo.flux.combinepublisher.util.AngkorAirline;
import java_reactive_demo.flux.combinepublisher.util.BangkokAir;
import java_reactive_demo.util.Util;
import reactor.core.publisher.Flux;

public class CP3Merge {

	public static void main(String[] args) {
		
			Flux.concat(
					AirAsia.getFlight(),
					AngkorAirline.getFlight(),
					BangkokAir.getFlight()
					)
			.subscribe(Util.subscriber());
		
			
			Util.sleep(10);
	}

}
