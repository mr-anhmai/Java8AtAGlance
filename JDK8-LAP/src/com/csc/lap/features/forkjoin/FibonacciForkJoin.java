package com.csc.lap.features.forkjoin;

import java.util.concurrent.RecursiveTask;

public class FibonacciForkJoin extends RecursiveTask<Long> {

	private static final long serialVersionUID = 1L;

	public static final String OUTPUT_PREFIX = " | ";

	private final String prefix;

	private final long inputValue;

	public FibonacciForkJoin(long inputValue, final String prefix) {
		this.inputValue = inputValue;
		this.prefix = prefix;
	}

	@Override
	public Long compute() {

		if (inputValue == 0L) {
		//1.1. my portion of the work is small enough --> Do the work directly
			return 0L;
		} else if (inputValue <= 2L) {
		//1.2. my portion of the work is small enough --> Do the work directly	return 1L;
			return 1L;
		} else {
		
			//2. split my work into two pieces
			//2.1. 1st piece
			final long firstValue = inputValue - 1L;
			System.out.println(prefix + " - Fibonacci(" + firstValue + ") <- "
					+ Thread.currentThread().getName() + " (fork) ");
			//2.1.1 Wrap this code in a ForkJoinTask subclass
			final FibonacciForkJoin firstWorker = new FibonacciForkJoin(
					firstValue, prefix + OUTPUT_PREFIX);
			firstWorker.fork();

			//2.2. 2nd piece
			final long secondValue = inputValue - 2L;
			System.out.println(prefix + " - Fibonacci(" + secondValue + ") <- "
					+ Thread.currentThread().getName());
			//2.2.1 Wrap this code in a ForkJoinTask subclass
			final FibonacciForkJoin secondWorker = new FibonacciForkJoin(
					secondValue, prefix + OUTPUT_PREFIX);

			long result = secondWorker.compute() + firstWorker.join();
			System.out.println(prefix + " - Fibonacci(" + inputValue + ") = "
					+ result + " <- " + Thread.currentThread().getName()
					+ " (join)");

			return result;
		}
	}

}