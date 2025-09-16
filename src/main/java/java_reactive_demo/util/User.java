package java_reactive_demo.util;

import lombok.Data;

@Data
public class User {
	private int id;
	private String name;
	
	public User(int id) {
		this.id = id;
		this.name = Util.faker().name().firstName();
	}
}
