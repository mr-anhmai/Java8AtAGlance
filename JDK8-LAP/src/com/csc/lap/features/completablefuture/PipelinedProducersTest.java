package com.csc.lap.features.completablefuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class PipelinedProducersTest {
	public static void main() {
		System.out.println("Task 2 is done synchronously after completing Task 1.");
		thenApply();
		System.out.println("Task 2 is done asynchronously with Task 1.");
		thenCompose();
		System.out.println("Task 1, 2 are executed independently and combined onces they're all completed.");
		thenCombine();
	}
	
	private static void thenApply(){
		ProducerA producer = new ProducerA("ProducerA");
		;
		long start = System.nanoTime();
		CompletableFuture<String> futureDataA = CompletableFuture.supplyAsync(
				() -> producer.getName() + " - Task1: " + producer.getInfoA("Blah blah.."));
		
		long invocationTime = ((System.nanoTime() - start) / 1_000_000);
		System.out.println("ProducerA - Invocation returned after " + invocationTime
				+ " msecs");
		
		CompletableFuture<String> futureDataB = futureDataA.thenApply(s -> {ProducerB producerB = new ProducerB("ProducerB");
									return "thenApply Task2: " + producerB.getInfoB(s);});
		invocationTime = ((System.nanoTime() - start) / 1_000_000);
		System.out.println("ProducerB - Invocation returned after " + invocationTime
				+ " msecs");
		
		// Do some more tasks.
		Util.doSomethingElse();
		// while info is retrieved
		
		try {
			String data = futureDataB.get();
			System.out.println("Data: " + data);
		} catch (ExecutionException | InterruptedException e) {
			throw new RuntimeException(e);
		}
		long retrievalTime = ((System.nanoTime() - start) / 1_000_000);
		System.out.println("Data returned after " + retrievalTime + " msecs");
	}
	
	private static void thenCompose(){
		ProducerA producer = new ProducerA("ProducerA");
		;
		long start = System.nanoTime();
		CompletableFuture<String> futureDataA = CompletableFuture.supplyAsync(
				() -> producer.getName() + " - Task1: " + producer.getInfoA("Blah blah.."));
		
		long invocationTime = ((System.nanoTime() - start) / 1_000_000);
		System.out.println("ProducerA - Invocation returned after " + invocationTime
				+ " msecs");
		
		CompletableFuture<String> futureDataB = futureDataA.thenCompose(s -> {ProducerB producerB = new ProducerB("ProducerB");
									return  CompletableFuture.supplyAsync(() -> "thenCompose Task2: " + producerB.getInfoB(s));});
		invocationTime = ((System.nanoTime() - start) / 1_000_000);
		System.out.println("ProducerB - Invocation returned after " + invocationTime
				+ " msecs");
		
		// Do some more tasks.
		Util.doSomethingElse();
		// while info is retrieved
		
		try {
			String data = futureDataB.get();
			System.out.println("Data: " + data);
		} catch (ExecutionException | InterruptedException e) {
			throw new RuntimeException(e);
		}
		long retrievalTime = ((System.nanoTime() - start) / 1_000_000);
		System.out.println("Data returned after " + retrievalTime + " msecs");
	}
	
	private static void thenCombine(){
		ProducerA producer = new ProducerA("ProducerA");
		;
		long start = System.nanoTime();
		CompletableFuture<String> futureDataA = CompletableFuture.supplyAsync(
				() -> producer.getName() + " - Task1: " + producer.getInfoA("Blah blah.."));
		
		long invocationTime = ((System.nanoTime() - start) / 1_000_000);
		System.out.println("ProducerA - Invocation returned after " + invocationTime
				+ " msecs");
		
		CompletableFuture<String> futureDataB = futureDataA.thenCombine(CompletableFuture.supplyAsync(() -> {ProducerB producerB = new ProducerB("ProducerB");
		return "thenCombine Task2: " + producerB.getInfoB("B Blah..");}), (dataA, dataB) -> " Result: " + dataA + dataB );
		invocationTime = ((System.nanoTime() - start) / 1_000_000);
		System.out.println("ProducerB - Invocation returned after " + invocationTime
				+ " msecs");
		
		// Do some more tasks.
		Util.doSomethingElse();
		// while info is retrieved
		
		try {
			String data = futureDataB.get();
			System.out.println("Data: " + data);
		} catch (ExecutionException | InterruptedException e) {
			throw new RuntimeException(e);
		}
		long retrievalTime = ((System.nanoTime() - start) / 1_000_000);
		System.out.println("Data returned after " + retrievalTime + " msecs");
	}
}
