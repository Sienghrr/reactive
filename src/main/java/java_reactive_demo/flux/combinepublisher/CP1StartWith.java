package java_reactive_demo.flux.combinepublisher;

import java_reactive_demo.flux.combinepublisher.util.StringGenerator;
import java_reactive_demo.util.Util;

public class CP1StartWith {

	public static void main(String[] args) {
		
		StringGenerator generator = new StringGenerator();
		
		generator.getName()
			.take(2)
			.subscribe(Util.subscriber("Dara"));
		
		generator.getName()
		.take(3)
		.subscribe(Util.subscriber("Thida"));
		
		generator.getName()
		.filter(name -> name.startsWith("T"))
		.take(2)
		.subscribe(Util.subscriber("Veasna"));
		
		
		
		
	}

}
