package com.csc.lap.features.completablefuture;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class SingleProducerTest {

	public static void main() {
		System.out.println("Asynchronous calls");
		async();
		System.out.println("Synchronous calls");
		sync();
	}

	private static void async(){
		Producer producer = new Producer("Async");
		;
		long start = System.nanoTime();
		Future<String> futureData = producer.getInfoAsync();
		long invocationTime = ((System.nanoTime() - start) / 1_000_000);
		System.out.println("Invocation returned after " + invocationTime
				+ " msecs");
		// Do some more tasks.
		Util.doSomethingElse();
		// while info is retrieved
		try {
			String data = futureData.get();
			System.out.println("Data: " + data);
		} catch (ExecutionException | InterruptedException e) {
			throw new RuntimeException(e);
		}
		long retrievalTime = ((System.nanoTime() - start) / 1_000_000);
		System.out.println("Data returned after " + retrievalTime + " msecs");
	}
	
	private static void sync(){
		Producer producer = new Producer("Sync");
		long start = System.nanoTime();
		String data = producer.getInfoSync();
		long invocationTime = ((System.nanoTime() - start) / 1_000_000);
		System.out.println("Invocation returned after " + invocationTime
				+ " msecs");
		System.out.println("Data: " + data);
		Util.doSomethingElse();
	}

}
