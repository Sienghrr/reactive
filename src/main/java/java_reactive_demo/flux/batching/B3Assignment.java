package java_reactive_demo.flux.batching;

import java.time.Duration;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import java_reactive_demo.util.Util;
import reactor.core.publisher.Flux;

public class B3Assignment {

	public static void main(String[] args) {
		//"Fantasy","Essay","Textbook"
		/*for(int i=0; i<50; i++) {
			String category =Util.faker().book().genre();
			System.out.println(category);
		}
		*/
		Set categories = Set.of("Fantasy","Essay","Textbook");
		flux()
			.filter(book -> categories.contains(book.getCategory()))
			.buffer(Duration.ofSeconds(2))
			.map(books -> calculateRevenue(books))
			.subscribe(Util.subscriber());
		
		Util.sleep(60);
	}
	
	private static RevenueReport calculateRevenue(List<BookOrder> books) {
		Map<String, Double> map = books.stream()
			.collect(Collectors.groupingBy(
					BookOrder::getCategory,
					Collectors.summingDouble(BookOrder::getPrice)
			));
		return new RevenueReport(map);
	}
	
	private static Flux<BookOrder> flux(){
		return Flux.interval(Duration.ofMillis(10))
					.map( x -> new BookOrder());
	}

}
