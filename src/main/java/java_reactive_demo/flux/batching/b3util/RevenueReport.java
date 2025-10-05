package java_reactive_demo.flux.batching.b3util;

import java.time.LocalDateTime;
import java.util.Map;

import lombok.Data;

@Data
public class RevenueReport {
	private LocalDateTime dateTime;
	private Map<String, Double> map;
	
	public RevenueReport(Map<String, Double> map) {
		this.map = map;
		dateTime = LocalDateTime.now();
	}

}
