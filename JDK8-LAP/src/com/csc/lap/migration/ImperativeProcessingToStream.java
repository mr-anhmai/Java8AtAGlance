package com.csc.lap.migration;

import static java.util.stream.Collectors.toList;

import java.util.ArrayList;
import java.util.List;

import com.csc.lap.domain.Dish;
import com.csc.lap.domain.ExampleData;

public class ImperativeProcessingToStream {

	public static void main(String[] args) {
		long time = System.currentTimeMillis();
		getLowPriceProductsInImperative(ExampleData.products).forEach(
				System.out::println);
		time = System.currentTimeMillis() - time;
		System.out.println("Processed in " + time + " milliseconds");
		time = System.currentTimeMillis();
		getLowPriceProductsInJava8(ExampleData.products).forEach(
				System.out::println);
		time = System.currentTimeMillis() - time;
		System.out.println("Processed in " + time + " milliseconds");
	}

	public static List<String> getLowPriceProductsImperative(
			List<Dish> products) {
		System.out.println("Imperative Approach");
		List<Dish> lowPriceProducts = new ArrayList<>();
		for (Dish d : products) {
			if (d.getCalories() < 850) {
				lowPriceProducts.add(d);
			}
		}

		List<String> lowPriceProductNames = new ArrayList<>();
		for (Dish d : lowPriceProducts) {
			lowPriceProductNames.add(d.getName());
		}
		return lowPriceProductNames;
	}

	public static List<String> getLowPriceProductsInJava8(List<Dish> products) {
		System.out.println("Using Stream API - Java8");
		return products.parallelStream().filter(p -> p.getCalories() < 850)
				.map(p -> p.getName()).collect(toList());

	}
}
