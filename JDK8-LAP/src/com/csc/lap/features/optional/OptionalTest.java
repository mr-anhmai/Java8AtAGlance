package com.csc.lap.features.optional;
import java.util.Optional;


public class OptionalTest {
	public static void print(Optional<String> optional) {
		if(optional.isPresent()) {
			System.out.println(optional.get());
		} else {
			System.out.println("Argument passed is null");
		}
	}
	
	public static void main(String[] args) {
		String nullString = null;
		System.out.println("Passed nullString to method print()");
		print(Optional.ofNullable(nullString));
		nullString = "Non null String";
		System.out.println("Passed nonNullString to method print()");
		print(Optional.ofNullable(nullString));
	}
}
