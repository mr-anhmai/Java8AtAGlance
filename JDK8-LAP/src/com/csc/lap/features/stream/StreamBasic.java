package com.csc.lap.features.stream;

import java.util.*;
import java.util.stream.*;

import com.csc.lap.domain.Dish;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;

public class StreamBasic {

    public static void main(String...args){
        // Java 7
        //getLowCaloricDishesNamesInJava7(Dish.menu).forEach(System.out::println);

        //System.out.println("---");

        // Java 8
        //getLowCaloricDishesNamesInJava8(Dish.menu).forEach(System.out::println);
        //getLowCaloricDishesNamesInJava8WithTrail(Dish.products).forEach(System.out::println);
        
        
        Stream.of(1, 5, 8,  4, 2).filter( n -> n < 5)
        	.collect(toList()).forEach(System.out::println);
        
        



        int t = 
        Stream.of(1, 5, 8,  4, 2).reduce(0, (a, b) -> a + b);
        
        System.out.println(t);
        
       

    }

     public static List<String> getLowCaloricDishesNamesInJava7(List<Dish> dishes){
        List<Dish> lowCaloricDishes = new ArrayList<>();
        for(Dish d: dishes){
            if(d.getCalories() > 400){
                lowCaloricDishes.add(d);
            }
        }
        List<String> lowCaloricDishesName = new ArrayList<>();
        Collections.sort(lowCaloricDishes, new Comparator<Dish>() {
            public int compare(Dish d1, Dish d2){
                return Integer.compare(d1.getCalories(), d2.getCalories());
            }
        });
        for(Dish d: lowCaloricDishes){
            lowCaloricDishesName.add(d.getName());
        }
        return lowCaloricDishesName;
    }

    public static List<String> getLowCaloricDishesNamesInJava8(List<Dish> dishes){
        return dishes.parallelStream()
                .filter(d -> d.getCalories() > 400)
                .sorted(comparing(Dish::getCalories))
                .map(Dish::getName)
                .collect(toList());
    }
    
    public static List<String> getLowCaloricDishesNamesInJava8WithTrail(List<Dish> dishes){
        return dishes.stream()
                .filter(d -> {System.out.println("filtering " + d.getName());
                	return d.getCalories() < 850;})
                .map(d -> {System.out.println("mapping " + d.getName());
            		return d.getName();})
            	.limit(2)
                .sorted((n1, n2)-> {System.out.println("sorting - comparing " + n1 + ", " + n2); 
                				return n1.compareTo(n2);})
                .collect(toList());
    }
    
}
