package com.csc.lap.features.defaultmethod;

public interface InfB {
	void nonDefaultMethod1();
	void nonDefaultMethod2();
	default public void defaultMethod(){
		System.out.println("Interface B - defaultMethod()");
	}
}
