package com.csc.lap.features.stream;

import java.io.BufferedReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class BuildingStreams {

	public static void main(String... args) {

		//1. FINITE STREAMS
		//1.1. Stream.of
		//java.util.stream.Stream<T> 
    	//Stream<T> of(T... values)
		Stream<String> stream = Stream.of("The", "quick", "fox",  "jumps", "over", "the", "lazy", "dog");
		stream.map(String::toUpperCase).forEach(System.out::println);
		

		//1.2. Arrays.stream
		int[] numbers = { 2, 3, 5, 7, 11, 13 };
		System.out.println(Arrays.stream(numbers).sum());
		//1.3. Steam.range
		Stream<Integer> rangedNumbers =  IntStream.rangeClosed(1, 100).boxed();
		rangedNumbers.forEach(System.out::println);

		//2. INFINITE STREAMS
		//2.1. Stream.iterate
		//static <T> Stream<T> iterate(T seed, UnaryOperator<T> f)

		Stream.iterate(0, n -> n + 2).limit(10).forEach(System.out::println);

		//2.2. Random stream of doubles with Stream.generate
		Stream.generate(Math::random).limit(10).forEach(System.out::println);
		//static <T> Stream<T> generate(Supplier<T> s)

				
		//java.util.Collection
		//Stream<T> stream
		Collection<String> c = new ArrayList();
		
		BufferedReader br;
		//java.io.BufferedReader
				//Stream<T> lines
		
	}
}
