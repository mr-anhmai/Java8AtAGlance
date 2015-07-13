package com.csc.lap.features.stream;

import static java.util.stream.Collectors.toList;

import java.util.Arrays;
import java.util.List;

import com.csc.lap.domain.Dish;
import com.csc.lap.domain.ExampleData;

public class Filtering{

    public static void main(String...args){

        // Filtering with predicate
        List<Dish> vegetarianMenu =
        		ExampleData.menu.stream()
                .filter(Dish::isVegetarian)
                .collect(toList());

        vegetarianMenu.forEach(System.out::println);

        // Filtering unique elements
        List<Integer> numbers = Arrays.asList(1, 2, 1, 3, 3, 2, 4);
        numbers.stream()
               .filter(i -> i % 2 == 0)
               .distinct()
               .forEach(System.out::println);

        // Truncating a stream
        List<Dish> dishesLimit3 =
            ExampleData.menu.stream()
                .filter(d -> d.getCalories() > 300)
                .limit(3)
                .collect(toList());

        dishesLimit3.forEach(System.out::println);

        // Skipping elements
        List<Dish> dishesSkip2 =
        		ExampleData.menu.stream()
                .filter(d -> d.getCalories() > 300)
                .skip(2)
                .collect(toList());

        dishesSkip2.forEach(System.out::println);
    }
}
