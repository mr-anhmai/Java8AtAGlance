package com.csc.lap.features.typeAnnotation;

import org.checkerframework.checker.nullness.qual.NonNull;

public class TypeAnnotation {
	public static void main(String[] args) {
		String s = null;
		print(s);
    }
	
	public static void print(@NonNull String s) {
		System.out.println(s);
	}
}
