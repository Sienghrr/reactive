package java_reactive_demo.util;

import java.time.LocalDateTime;
import java.util.function.Consumer;

import reactor.core.publisher.FluxSink;

public class ColorProducer implements Consumer<FluxSink<String>>{
	private FluxSink<String> fluxSink;

	@Override
	public void accept(FluxSink<String> t) {
		// TODO Auto-generated method stub
		//t.next("Red");
		this.fluxSink = t;
	}
	
	public void produce() {
		String threadName = Thread.currentThread().getName();
		
		fluxSink.next( LocalDateTime.now() + " - "+ threadName + " - " + Util.faker().color().name());
	}

}
