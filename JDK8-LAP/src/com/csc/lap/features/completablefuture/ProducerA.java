package com.csc.lap.features.completablefuture;

public class ProducerA {

	private final String name;

	public ProducerA(String name) {
		this.name = name;
	}

	public String getInfoA(String s) {
		System.out.println("Process A data - Starts");
		// Simulate the time to process data (I/O Operations, Database)
		Util.delay();
		System.out.println("Process A data - Ends");
		return this.name + ": A DATA - " + s;
	}

	public String getName() {
		return name;
	}

}
