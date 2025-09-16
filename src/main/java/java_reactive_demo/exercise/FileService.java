package java_reactive_demo.exercise;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import reactor.core.publisher.Mono;

public class FileService {
	
	public static Mono<String> read(String fileName){
		return Mono.fromSupplier(() -> readFile(fileName));
	}
	
	private static String readFile(String fileName) {
		System.out.println("Reading file....");
		Path path = Paths.get("src/main/resources");
		try {
			return Files.readString(path.resolve(fileName));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

}
