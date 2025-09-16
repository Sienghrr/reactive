package java_reactive_demo.util;

import lombok.Data;

@Data
public class Student {
	private String name;
	private int age;
	
	public Student() {
		this.name = Util.faker().name().firstName();
		this.age = Util.faker().random().nextInt(10, 20);
	}
}
