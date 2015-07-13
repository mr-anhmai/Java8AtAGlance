package com.csc.lap.features.completablefuture;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

public class Producer {

	private final String name;
	private final Random random;

	public Producer(String name) {
		this.name = name;
		random = new Random(100);
	}

	public String getInfoSync() {
		return processData();
	}

	public Future<String> getInfoAsync() {
		return CompletableFuture.supplyAsync(() -> processData());
	}

	private String processData() {
		System.out.println("Process data - Starts");
		// Simulate the time to process data (I/O Operations, Database)
		Util.delay();
		System.out.println("Process data - Ends");
		return this.name + ": ProcessID #" + random.nextInt();

	}

	public String getName() {
		return name;
	}

}
