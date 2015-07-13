package com.csc.lap.domain;

import java.util.Arrays;
import java.util.List;

public class ExampleData {

	 public static final List<Dish> menu =
	            Arrays.asList( new Dish("pork", false, 200, Dish.Type.MEAT),
	                           new Dish("beef", false, 700, Dish.Type.MEAT),
	                           new Dish("chicken", false, 400, Dish.Type.MEAT),
	                           new Dish("french fries", true, 530, Dish.Type.OTHER),
	                           new Dish("rice", true, 350, Dish.Type.OTHER),
	                           new Dish("season fruit", true, 120, Dish.Type.OTHER),
	                           new Dish("pizza", true, 550, Dish.Type.OTHER),
	                           new Dish("prawns", false, 400, Dish.Type.FISH),
	                           new Dish("salmon", false, 450, Dish.Type.FISH));
	    
	    public static final List<Dish> products =
	            Arrays.asList( new Dish("iPhone6", false, 600, Dish.Type.MEAT),
	                           new Dish("iPadAir3", false, 850, Dish.Type.MEAT),
	                           new Dish("bPhone", false, 700, Dish.Type.MEAT),
	                           new Dish("MacPro", true, 1500, Dish.Type.OTHER),
	                           new Dish("Surface3", true, 1000, Dish.Type.OTHER),
	                           new Dish("iPhone6+", true, 800, Dish.Type.OTHER)
	                           );
	    
	    public static final List<Apple> inventory =
	    		Arrays.asList(new Apple("Red", 200),
	    				new Apple("Green", 300),
	    				new Apple("Red", 270),
	    				new Apple("Red", 210),
	    				new Apple("Green", 280)
	    				);
			
}
