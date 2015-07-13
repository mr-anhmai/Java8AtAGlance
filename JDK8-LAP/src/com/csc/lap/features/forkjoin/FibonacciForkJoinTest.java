package com.csc.lap.features.forkjoin;

import java.util.concurrent.ForkJoinPool;

import com.csc.lap.common.Constants;

public class FibonacciForkJoinTest {

	private static final int AVAILABLE_PROCESSORS = Runtime.getRuntime()
			.availableProcessors();

	// create thread pool
	private static final ForkJoinPool pool = new ForkJoinPool(
			AVAILABLE_PROCESSORS);

	public static void main(String[] args) {
		System.out.println("Number of available Processors: "
				+ Runtime.getRuntime().availableProcessors());
		long startTime = 0;
		long stopTime = 0;
		long elapsedTime = 0;

		System.out.println("FIBONACCI - USING FORK/JOIN FRAMEWORK");
		startTime = System.currentTimeMillis();
		for (int inputValue = 0; inputValue < Constants.FINONACCI_TARGET_NUMBER; inputValue++) {

			final FibonacciForkJoin task = new FibonacciForkJoin(inputValue,
					" | ");
			System.out.println("invoke Fibonacci(" + inputValue + ")  <- "
					+ Thread.currentThread().getName());
			// 3. pass it to the invoke() method of a ForkJoinPool instance.
			final long result = pool.invoke(task);
			System.out.println("result = " + result + "\n");

		}
		stopTime = System.currentTimeMillis();
		elapsedTime = stopTime - startTime;
		System.out.println("\nExcecution Time: " + elapsedTime
				+ " (miliseconds)");
	}
}
