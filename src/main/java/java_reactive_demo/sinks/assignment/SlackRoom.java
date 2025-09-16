package java_reactive_demo.sinks.assignment;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Sinks;

public class SlackRoom {
	private String name;
	private Sinks.Many<SlackMessage> sink;
	private Flux<SlackMessage> flux;
	
	public SlackRoom(String name) {
		this.name = name;
		this.sink = Sinks.many().replay().all();
		this.flux = sink.asFlux();
	}
	
	public void joinRoom(SlackMember slackMember) {
		System.out.println(slackMember.getName() + "---- joined ---- " + name);
		subscribes(slackMember);
		slackMember.setMessageConsumer(msg -> postMessage(msg, slackMember));
	}
	
	private void subscribes(SlackMember slackMember) {
		this.flux
			.filter(sm -> !sm.getSender().equals(slackMember.getName()))
			.doOnNext(sm -> sm.setReceiver(slackMember.getName()))
			//.map(sm -> sm.toString())
			.map(SlackMessage::toString)
			.subscribe(slackMember::receives);
			//.subscribe(sm -> slackMember.receives(sm.getMessage()));
	}
	
	private void postMessage(String msg, SlackMember slackMember) {
		SlackMessage slackMessage = new SlackMessage();
		slackMessage.setSender(slackMember.getName());
		slackMessage.setMessage(msg);
		this.sink.tryEmitNext(slackMessage);
	}
	
	
}
