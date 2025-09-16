package java_reactive_demo.util;

import java.util.function.Consumer;

import com.github.javafaker.Faker;

public class Util {
	
	private static final Faker FAKER = Faker.instance();
	
	public static Consumer<String> onNext(){
		return x -> System.out.println("onNext: " +x);
	}
	
	public static Consumer<Throwable> onError(){
		return x -> System.out.println("onError: "+ x.getMessage());
	}
	
	public static Runnable onComplete(){
		return () -> System.out.println("onComplete: Done");
	}
	
	public static void sleep(int second) {
		sleepMili(second * 1000);
	}
	
	public static void sleepMili(int mili) {
		try {
			Thread.sleep(mili);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public static Faker faker() {
		return FAKER;
	}
	
	public static DefaultSubscriber subscriber(String name) {
		return new DefaultSubscriber(name);
	}
	
	public static DefaultSubscriber subscriber() {
		return new DefaultSubscriber();
	}
	

}
