package com.csc.lap.features.completablefuture;

public class ProducerB {

	private final String name;

	public ProducerB(String name) {
		this.name = name;
	}

	public String getInfoB(String s) {
		System.out.println("Process B data - Starts");
		// Simulate the time to process data (I/O Operations, Database)
		Util.delay();
		System.out.println("Process B data - Ends");
		return this.name + ": B DATA - " + s;
	}

	public String getName() {
		return name;
	}

}
