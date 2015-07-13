package com.csc.lap.features.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import com.csc.lap.domain.Apple;
import com.csc.lap.domain.ExampleData;



public class ComposingLambdaExpressionTest {

    public static void main(String...args){

    	chainingComparators();
    	composingPredicates();
    	composingFunctions();

	}
    
    private static void chainingComparators(){
    	System.out.println("CHAINING COMPARATORS: Sort by Weight DES then Color ASC");
        
    	ExampleData.inventory.sort(Comparator.comparing((Apple apple) -> apple.getWeight())
        		.reversed()
        		.thenComparing((Apple apple) -> apple.getColor()));
		System.out.println(ExampleData.inventory);
    }
    
    private static void composingPredicates(){
    	
        System.out.println("COMPOSING PREDICATES: COLOR != 'Red' && WEIGHT > 150");
        
        Predicate<Apple> redApple = apple -> apple.getColor().equals("red");
        Predicate<Apple> notRedApple = redApple.negate();
        Predicate<Apple> redAndHeavyApple = notRedApple.and(apple -> apple.getWeight() > 125);
        List<Apple> result = ExampleData.inventory.stream().filter(redAndHeavyApple).collect(Collectors.toList());
		System.out.println(result);
    }
    
    private static void composingFunctions(){
    	
    	List<Integer> inputs = new ArrayList<>();
    	inputs.addAll(Arrays.asList(1,2,3,4));
        
    	Function<Integer, Integer> f = x -> x + 1;
    	Function<Integer, Integer> g = y -> y*2;
    	
    	Function<Integer, Integer> h = f.andThen(g);
    	
    	Function<Integer, Integer> i = f.compose(g);

    	System.out.println("andThen:  returns a function that first applies a given function to an input and then applies another function to the result of that application.");
        inputs.stream().forEach(input -> System.out.println(input + " --> f(x) = x + 1 --> " + f.apply(input) + " --> g(y) = y*2 --> " + h.apply(input)));
        
        System.out.println("compose: first apply the function given as argument to compose and then apply the function to the result.");
        inputs.stream().forEach(input -> System.out.println(input + " --> g(y) = y*2 --> " + g.apply(input) + " --> f(x) = x + 1 --> " + i.apply(input)));
    }

	

	static class AppleComparator implements Comparator<Apple> {
		public int compare(Apple a1, Apple a2) {
			return a1.getWeight().compareTo(a2.getWeight());
		}
	}
}