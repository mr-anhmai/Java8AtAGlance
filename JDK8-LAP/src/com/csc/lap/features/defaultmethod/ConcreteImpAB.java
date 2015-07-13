package com.csc.lap.features.defaultmethod;

public class ConcreteImpAB implements InfA, InfB {
	public void nonDefaultMethod1() {
		System.out.println("Concrete ImpAB - calling nonDefaultMethod1()");
	}

	public void nonDefaultMethod2() {
		System.out.println("Concrete ImpAB - calling nonDefaultMethod2()");
	}
	
	public void defaultMethod(){
		InfB.super.defaultMethod();
	}
	
	
}
