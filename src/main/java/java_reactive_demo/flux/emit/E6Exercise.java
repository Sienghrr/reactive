package java_reactive_demo.flux.emit;

import java.nio.file.Path;
import java.nio.file.Paths;

import java_reactive_demo.util.FileReaderService;
import java_reactive_demo.util.Util;

public class E6Exercise {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Path path = Paths.get("src/main/resources/file01.txt");
		FileReaderService fileReaderService = new FileReaderService();
		fileReaderService.readFile(path)
			//.take(10)
			.map(x ->{
				Integer number = Util.faker().random().nextInt(0, 10);
				if(number > 7) {
					throw new RuntimeException("Somthing error !!!");
				}
				return number;
			})
			.subscribe(Util.subscriber());
		

	}

}
