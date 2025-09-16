package java_reactive_demo.flux.batching;

import com.github.javafaker.Book;

import java_reactive_demo.util.Util;
import lombok.Data;

@Data
public class BookOrder {
	private String title;
	private String category;
	private double price;
	
	public BookOrder() {
		Book book = Util.faker().book();
		this.title = book.title();
		this.category = book.genre();
		this.price = Double.parseDouble(Util.faker().commerce().price());
	}
}
