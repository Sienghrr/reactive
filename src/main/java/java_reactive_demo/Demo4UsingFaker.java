package java_reactive_demo;

import com.github.javafaker.Faker;

import java_reactive_demo.util.CountryRepository;
import java_reactive_demo.util.Util;
import reactor.core.publisher.Mono;

public class Demo4UsingFaker {

	public static void main(String[] args) {
		
		
		
//		for(int i=0; i<10; i++) {
//			String name = Faker.instance().color().name();
//			System.out.println(name);
//		}
		
		
		CountryRepository.findByid(24)
			.subscribe(Util.onNext(), Util.onError(),Util.onComplete());
		
	}

}
