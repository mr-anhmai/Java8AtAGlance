package com.csc.lap.features.defaultmethod;

public interface  InfA {
	void nonDefaultMethod1();
	void nonDefaultMethod2();
	default public void defaultMethod(){
		System.out.println("Interface A - defaultMethod()");
	}
}
