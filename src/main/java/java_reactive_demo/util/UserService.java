package java_reactive_demo.util;

import reactor.core.publisher.Flux;

public class UserService {

	public Flux<User> getUser(){
		return Flux.range(1, 2)
					.map(x -> new User(x));
	}
}
