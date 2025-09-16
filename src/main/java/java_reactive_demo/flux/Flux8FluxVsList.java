package java_reactive_demo.flux;

import java.util.List;

import java_reactive_demo.util.ColorGenerator;

public class Flux8FluxVsList {

	public static void main(String[] args) {
		
		ColorGenerator generator = new ColorGenerator();
		System.out.println("..... loading");
		//List<String> colors = generator.getColors(5);
		//System.out.println(colors);
		
		generator.getColorsV2(5)
			.subscribe(x -> System.out.println(x));
	
	}

}
