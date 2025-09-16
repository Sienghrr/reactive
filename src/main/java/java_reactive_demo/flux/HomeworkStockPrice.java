package java_reactive_demo.flux;

import java.util.concurrent.CountDownLatch;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import java_reactive_demo.util.StockPriceGenerator;
import java_reactive_demo.util.Util;

public class HomeworkStockPrice {

	public static void main(String[] args) throws InterruptedException {
		StockPriceGenerator priceGenerator = new StockPriceGenerator();
		CountDownLatch countDownLatch = new CountDownLatch(1);
		
		priceGenerator.getPrice()
			//.subscribe(x -> System.out.println(x));
			.subscribe(new Subscriber<Integer>() {
				private Subscription subscription;

				@Override
				public void onSubscribe(Subscription s) {
					// TODO Auto-generated method stub
					this.subscription = s;
					s.request(Long.MAX_VALUE);
				}

				@Override
				public void onNext(Integer t) {
					System.out.println("Recieved: " + t);
					if(t > 105 || t < 90) {
						this.subscription.cancel();
					}
					//countDownLatch.countDown();
				}

				@Override
				public void onError(Throwable t) {
					System.out.println("Error: " + t.getMessage());
					countDownLatch.countDown();
				}

				@Override
				public void onComplete() {
					// TODO Auto-generated method stub
					System.out.println("Completed.");
					countDownLatch.countDown();
				}
			});
		
		//Util.delay(5);
		countDownLatch.await();
	}

}
