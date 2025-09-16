package java_reactive_demo;

import java.util.Optional;
import java.util.stream.Stream;

import com.github.javafaker.Faker;

import java_reactive_demo.util.Util;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

public class Demo6Pipeline {

	public static void main(String[] args) {
		
		getName();
		getName()
			.subscribeOn(Schedulers.boundedElastic())
			.subscribe(x -> System.out.println(x));
		getName();
		Util.sleep(4);
		
		//block
		//user from database by id
		int userId=10;
		
		//User user = userRepo.findById(userId);
		//UserPreference pre = pref.findById(userId);
		//UserPreference pre = pref.findByUserName(user.getName());
		
		
		
	}
	
	// Build pipeline
	private static Mono<String> getName() {
		System.out.println("Entering to method");
		return Mono.fromSupplier(() ->{
			System.out.println("Generating name ...");
			Util.sleep(3);
			return Faker.instance().country().name();
		}).map(x -> x.toUpperCase());
		 
	}

}
