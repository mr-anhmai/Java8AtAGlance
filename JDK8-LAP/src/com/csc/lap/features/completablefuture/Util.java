package com.csc.lap.features.completablefuture;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Util {

	public static void delay() {
		int delay = 1000;
		try {
			Thread.sleep(delay);
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
	}

	public static void doSomethingElse() {

		System.out.println("Doing something else...start");
		delay();
		delay();
		System.out.println("Doing something else...end.");
	}

	public static <T> CompletableFuture<List<T>> sequence(
			List<CompletableFuture<T>> futures) {
		return CompletableFuture.supplyAsync(() -> futures.stream()
				.map(future -> future.join()).collect(Collectors.<T> toList()));
	}

	
}
