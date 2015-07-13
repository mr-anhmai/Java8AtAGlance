package com.csc.lap.features.forkjoin;


public class FibonacciBase {

	private static final long serialVersionUID = 1L;

	public static final String OUTPUT_PREFIX = " | ";

	private final String prefix;

	private final long inputValue;

	public FibonacciBase(long inputValue, final String prefix) {
		this.inputValue = inputValue;
		this.prefix = prefix;
	}

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
					+ Thread.currentThread().getName() + " (divide) ");
			final FibonacciBase firstWorker = new FibonacciBase(
					firstValue, prefix + OUTPUT_PREFIX);
			

			//2.2. 2nd piece
			final long secondValue = inputValue - 2L;
			System.out.println(prefix + " - Fibonacci(" + secondValue + ") <- "
					+ Thread.currentThread().getName());
			final FibonacciBase secondWorker = new FibonacciBase(
					secondValue, prefix + OUTPUT_PREFIX);

			long result =  firstWorker.compute() + secondWorker.compute();
			System.out.println(prefix + " - Fibonacci(" + inputValue + ") = "
					+ result + " <- " + Thread.currentThread().getName()
					+ " (join)");

			return result;
		}
	}

}