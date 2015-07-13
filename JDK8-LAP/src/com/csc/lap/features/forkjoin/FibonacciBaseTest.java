package com.csc.lap.features.forkjoin;

import com.csc.lap.common.Constants;

public class FibonacciBaseTest {

	public static void main(String[] args) {
		long startTime = 0;
		long stopTime = 0;
		long elapsedTime = 0;

		System.out.println("FIBONACCI - NOT USING FORK/JOIN FRAMEWORK");
		startTime = System.currentTimeMillis();

		for (int inputValue = 0; inputValue < Constants.FINONACCI_TARGET_NUMBER; inputValue++) {
			final FibonacciBase task = new FibonacciBase(inputValue, " | ");
			System.out.println("invoke Fibonacci(" + inputValue + ")  <- "
					+ Thread.currentThread().getName());

			final long result = task.compute();
			System.out.println("result = " + result + "\n");

		}

		stopTime = System.currentTimeMillis();
		elapsedTime = stopTime - startTime;
		System.out.println("\nExcecution Time: " + elapsedTime
				+ " (miliseconds)");
	}
}
