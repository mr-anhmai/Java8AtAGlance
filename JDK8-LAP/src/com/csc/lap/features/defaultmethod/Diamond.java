package com.csc.lap.features.defaultmethod;

public class Diamond{

    public static void main(String...args){
        new D().hello();
    }

    static interface A{
        public default void hello(){
            System.out.println("Hello from A");
        }
    }

    static interface B extends A { 
    	public default void hello(){
            System.out.println("Hello from B");
        }
    }

    static interface C extends A {
    	/*
    	public default void hello(){
            System.out.println("Hello from C");
        }
        */
    }

    static class D implements B, C {

    }
}
