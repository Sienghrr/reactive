package java_reactive_demo.util;

import org.reactivestreams.Subscription;

import com.github.javafaker.Faker;

import reactor.core.publisher.Mono;

public class CountryRepository {
	
	public static Mono<String>  findByid(int countryId) {
		if(countryId == 1) {
			return Mono.just(Faker.instance().country().name());
		}else if(countryId == 2){
			return Mono.empty();
		}
		return Mono.error(new RuntimeException("countryId provided is not in the range"));
	}
	
	//onNext , onError, onComplete

}
