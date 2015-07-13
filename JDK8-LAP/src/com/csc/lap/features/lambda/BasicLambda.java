package com.csc.lap.features.lambda;

import java.util.ArrayList;
import java.util.List;

import com.csc.lap.domain.Apple;
import com.csc.lap.domain.ExampleData;



interface Predicate {
	boolean test(Apple apple);
}

class HeavyApplePredicate implements Predicate {
	public boolean test(Apple apple) {
		return apple.getWeight() > 250;
	}
}

public class BasicLambda {

	public static List<Apple> filter(List<Apple> inventory, int weight) {
		List<Apple> result = new ArrayList<Apple>();
		for (Apple apple : inventory) {
			if (apple.getWeight() > weight)
				result.add(apple);
		}
		return result;
	}

	
	public static void main() {
		
		System.out.println("Value Parameterization");
		System.out.println("Results " + filter(ExampleData.inventory, 250));

		System.out.println("Behavior Parameterization - Classes");

		Predicate p = new HeavyApplePredicate();
		System.out.println("Results " + filter(ExampleData.inventory, p));

		System.out.println("Behavior Parameterization - Anonymous Classes");
		System.out.println("Results " + filter(ExampleData.inventory, new Predicate() {
			public boolean test(Apple apple) {
				return apple.getWeight() > 250;
			}
		}));

		System.out.println("Behavior Parameterization - Lambda Expression");
		System.out.println("Results "
				+ filter(ExampleData.inventory, apple -> apple.getWeight() > 250));

	}

	public static List<Apple> filter(List<Apple> inventory, Predicate p) {
		List<Apple> result = new ArrayList<Apple>();
		for (Apple apple : inventory) {
			if (p.test(apple))
				result.add(apple);
		}
		return result;
	}

}
