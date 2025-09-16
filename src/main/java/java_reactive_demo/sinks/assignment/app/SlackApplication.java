package java_reactive_demo.sinks.assignment.app;

import java_reactive_demo.sinks.assignment.SlackMember;
import java_reactive_demo.sinks.assignment.SlackRoom;

public class SlackApplication {
	public static void main(String[] args) {
		SlackRoom room = new SlackRoom("Java Reactive Classroom");
		
		SlackMember dara = new SlackMember("Dara");
		SlackMember rith = new SlackMember("Rith");
		SlackMember thida = new SlackMember("Thida");
		
		room.joinRoom(dara);
		room.joinRoom(rith);
		
		dara.says("Hello Everyone!");
		rith.says("Hey guys!");
		dara.says("I just want to say hello!");
		
		room.joinRoom(thida);
		thida.says("Hi, I am glad to be here.");
		
		
		
	}
}
