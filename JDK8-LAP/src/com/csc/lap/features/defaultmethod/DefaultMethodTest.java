package com.csc.lap.features.defaultmethod;


public class DefaultMethodTest {
	
	interface  InfA {
		default public void defaultMethod(){
			System.out.println("Interface A - defaultMethod()");
		}
	}
	
	interface InfB {
		default public void defaultMethod(){
			System.out.println("Interface B - defaultMethod()");
		}
	}
	
	class ConcreteImpAB implements InfA, InfB {
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
	
	
	interface Car{
		void start();
		void run();
		void stop();
		//new feature
		default void fly(){
			System.out.println("Not Exist");
		};
	}
	
	class LegacyCar implements Car{
		@Override
		public void start() {
			System.out.println("Start");
		}

		@Override
		public void run() {
			System.out.println("Run");
		}

		@Override
		public void stop() {
			System.out.println("Brake");
			
		}
	}
	
	
	class FutureCar implements Car{
		@Override
		public void start() {
			System.out.println("Start");
		}

		@Override
		public void run() {
			System.out.println("Run");
		}

		@Override
		public void stop() {
			System.out.println("Brake");
			
		}
		@Override
		public void fly() {
			System.out.println("Fly");
			
		}
	}
		
	public static void main(String[] args) {
	
		
		
		ConcreteImpA a = new ConcreteImpA();
		a.nonDefaultMethod1();
		a.nonDefaultMethod2();
		a.defaultMethod();

		ConcreteImpAB ab = new DefaultMethodTest().new ConcreteImpAB();
		ab.nonDefaultMethod1();
		ab.nonDefaultMethod2();
		ab.defaultMethod();

		
	}

	
}
