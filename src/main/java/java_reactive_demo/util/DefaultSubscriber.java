package java_reactive_demo.util;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public class DefaultSubscriber implements Subscriber<Object>{
	private String name ="";
	
	public DefaultSubscriber(String name) {
		this.name = name + " - ";
	}
	
	public DefaultSubscriber() {
	}

	@Override
	public void onSubscribe(Subscription s) {
		//System.out.println("Sub");
		s.request(Long.MAX_VALUE);
	}

	@Override
	public void onNext(Object t) {
		// TODO Auto-generated method stub
		System.out.println(name + "Recieved: " + t);
	}

	@Override
	public void onError(Throwable t) {
		// TODO Auto-generated method stub
		System.out.println(name + "Error: " + t.getMessage());
	}

	@Override
	public void onComplete() {
		// TODO Auto-generated method stub
		System.out.println(name + "Completed.");
	}

}
