package com.csc.lap.features.completablefuture;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class ListOfProducersTest {

	private final List<Producer> producers = Arrays.asList(
			new Producer("Producer1"), 
			new Producer("Producer2"), 
			new Producer("Producer3"),
			new Producer("Producer4"));

	public List<String> findInfoSequential() {
		return producers
				.stream()
				.map(producer -> producer.getName() + " - Data: "
						+ producer.getInfoSync()).collect(Collectors.toList());
	}

	public List<String> findInfoParallel() {
		return producers
				.parallelStream()
				.map(producer -> producer.getName() + " - Data: "
						+ producer.getInfoSync()).collect(Collectors.toList());
	}

	public List<String> findInfoFuture() {
		// Retrieve info asynchronously
		List<CompletableFuture<String>> priceFutures = producers
				.parallelStream()
				.map(producer -> CompletableFuture.supplyAsync(() -> producer
						.getName() + " - Data: " + producer.getInfoSync()))
				.collect(Collectors.toList());

		// Waiting for the completion of all asynchronous operations
		List<String> prices = priceFutures.stream()
				.map(CompletableFuture::join).collect(Collectors.toList());
		return prices;
	}

	private static void execute(String msg, Supplier<List<String>> s) {
		long start = System.nanoTime();
		System.out.println(s.get());
		long duration = (System.nanoTime() - start) / 1_000_000;
		System.out.println(msg + " done in " + duration + " msecs");
	}

	public static void main(String[] args) {
		ListOfProducersTest test = new ListOfProducersTest();
		execute("sequential", () -> test.findInfoSequential());
		execute("parallel", () -> test.findInfoParallel());
		execute("asynchronous", () -> test.findInfoFuture());
	}

}
