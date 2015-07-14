package com.csc.lap.migration;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

import com.csc.lap.domain.Dish;
import com.csc.lap.domain.ExampleData;

public class AnonymousToLambda {

	 public static void main(String...args){
	        // Java 7
		 sortCollectionInJava7(ExampleData.menu);

	       // Java 8
		 sortCollectionInJava8(ExampleData.menu);
	       

	    }
	 
	public static void sortCollectionInJava7(List<Dish> dishes){
		System.out.println("Java 7");
        
		Collections.sort(dishes, new Comparator<Dish>() {
            public int compare(Dish d1, Dish d2){
                return Integer.compare(d1.getCalories(), d2.getCalories());
            }
        });
        System.out.println(dishes);
    }

    public static void sortCollectionInJava8(List<Dish> dishes){
    	System.out.println("Java 8");
        Collections.sort(dishes, (d1, d2) -> Integer.compare(d1.getCalories(), d2.getCalories()));
        
        System.out.println(dishes);
       
    }
}
