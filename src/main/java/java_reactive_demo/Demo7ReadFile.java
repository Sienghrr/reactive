package java_reactive_demo;

import java_reactive_demo.exercise.FileService;
import java_reactive_demo.util.Util;

public class Demo7ReadFile {

	public static void main(String[] args) {
		FileService.read("file1.txt")
			.subscribe(Util.onNext(), Util.onError(),Util.onComplete());;
		
		
	}
	
	
}
