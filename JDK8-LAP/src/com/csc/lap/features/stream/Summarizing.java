package com.csc.lap.features.stream;

import java.util.stream.Collectors;

import com.csc.lap.domain.Dish;
import com.csc.lap.domain.ExampleData;



public class Summarizing {

    public static void main(String ... args) {
        System.out.println("Nr. of dishes: " + howManyDishes());
        System.out.println("The most caloric dish is: " + findMostCaloricDish());
        System.out.println("Total calories in menu: " + calculateTotalCalories());
        System.out.println("Average calories in menu: " + calculateAverageCalories());

    }


    private static long howManyDishes() {
        return ExampleData.menu.stream().collect(Collectors.counting());
    }

    private static Dish findMostCaloricDish() {
        return ExampleData.menu.stream().collect(Collectors.reducing((d1, d2) -> d1.getCalories() > d2.getCalories() ? d1 : d2)).get();
    }

    
    private static int calculateTotalCalories() {
        return ExampleData.menu.stream().collect(Collectors.summingInt(Dish::getCalories));
    }

    private static Double calculateAverageCalories() {
        return ExampleData.menu.stream().collect(Collectors.averagingInt(Dish::getCalories));
    }


}
