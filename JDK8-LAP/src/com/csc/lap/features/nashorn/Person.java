package com.csc.lap.features.nashorn;

public class Person {
	String name;
	int age;
	public Person() {
		name="default";
		age = 1;
	}
	public Person(String sName, int nAge) {
		name = sName;
		age = nAge;
	}
	
	public String toString() {
		return (name + " " + age);
	}
}
