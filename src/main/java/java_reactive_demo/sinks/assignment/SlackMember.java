package java_reactive_demo.sinks.assignment;

import java.util.function.Consumer;

public class SlackMember {
	private String name;
	private Consumer<String> messageConsumer;
	
	public SlackMember(String name) {
		this.name = name;
	}
	
	void receives(String msg) {
		System.out.println(msg);
	}

	public String getName() {
		return name;
	}
	
	public void says(String msg) {
		this.messageConsumer.accept(msg);
	}

	void setMessageConsumer(Consumer<String> messageConsumer) {
		this.messageConsumer = messageConsumer;
	}
	
	

}
