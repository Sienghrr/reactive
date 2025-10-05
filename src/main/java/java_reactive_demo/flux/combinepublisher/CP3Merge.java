package java_reactive_demo.flux.combinepublisher;

import java_reactive_demo.flux.combinepublisher.util.AirAsia;
import java_reactive_demo.flux.combinepublisher.util.AngkorAirline;
import java_reactive_demo.flux.combinepublisher.util.BangkokAir;
import java_reactive_demo.util.Util;
import reactor.core.publisher.Flux;

public class CP3Merge {

	public static void main(String[] args) {
		
			Flux.merge(
					AirAsia.getFlight(),
					AngkorAirline.getFlight(),
					BangkokAir.getFlight())// use merge for parallel processing
//					).concat(
//					AirAsia.getFlight(),
//					AngkorAirline.getFlight(),
//					BangkokAir.getFlight()
//					) if we use concat , it is not parallel processing
			.subscribe(Util.subscriber());
		
			
			Util.sleep(10);
	}

}
