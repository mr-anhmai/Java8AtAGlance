package com.csc.lap.features.typeAnnotation;
public class RepeatingAnnotation {
	
	@Schedule(dayOfMonth="second")
	public void runSomething() {
		
	}
	
	@Schedule(dayOfWeek="Thu")
	@Schedule(dayOfMonth="first")
	public void runAnotherThing() {
		
	}
}
