package java_reactive_demo.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.function.BiFunction;
import java.util.function.Consumer;

import reactor.core.publisher.Flux;
import reactor.core.publisher.SynchronousSink;

public class FileReaderService {
	
	private Callable<BufferedReader> openReader(Path path){
		return () -> Files.newBufferedReader(path);
	}
	
	private BiFunction<BufferedReader, SynchronousSink<String>, BufferedReader> read(){
		return (reader, sink) ->{
			try {
				String line = reader.readLine();
				if(Objects.isNull(line)) {
					sink.complete();
				}else {
					sink.next(line);
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				sink.error(new RuntimeException(e));
			}
			return reader;
		};
	}
	
	private Consumer<BufferedReader> closeReader(){
		return reader ->{
			try {
				reader.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		};
	}
	
	public Flux<String> readFile(Path path){
		return Flux.generate(openReader(path), read(), closeReader());
	}

}
