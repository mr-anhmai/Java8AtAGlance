package com.csc.lap.features.stream;


import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import com.csc.lap.domain.Dish;
import com.csc.lap.domain.ExampleData;

public class Grouping {

    enum CaloricLevel { DIET, NORMAL, FAT };

    public static void main(String ... args) {
        System.out.println("Dishes grouped by type: " + groupDishesByType());
        System.out.println("Dishes grouped by caloric level: " + groupDishesByCaloricLevel());
        System.out.println("Dishes grouped by type and caloric level: " + groupDishedByTypeAndCaloricLevel());
        System.out.println("Count dishes in groups: " + countDishesInGroups());
        System.out.println("Most caloric dishes by type: " + mostCaloricDishesByType());
        System.out.println("Sum calories by type: " + sumCaloriesByType());
        System.out.println("Caloric levels by type: " + caloricLevelsByType());
        
    }

    private static Map<Dish.Type, List<Dish>> groupDishesByType() {
        return ExampleData.menu.stream().collect(Collectors.groupingBy(Dish::getType));
    }

    private static Map<CaloricLevel, List<Dish>> groupDishesByCaloricLevel() {
        return ExampleData.menu.stream().collect(
        		Collectors.groupingBy(dish -> {
                    if (dish.getCalories() <= 400) return CaloricLevel.DIET;
                    else if (dish.getCalories() <= 700) return CaloricLevel.NORMAL;
                    else return CaloricLevel.FAT;
                } ));
    }

    private static Map<Dish.Type, Map<CaloricLevel, List<Dish>>> groupDishedByTypeAndCaloricLevel() {
        return ExampleData.menu.stream().collect(
        		Collectors.groupingBy(Dish::getType,
                		Collectors.groupingBy((Dish dish) -> {
                            if (dish.getCalories() <= 400) return CaloricLevel.DIET;
                            else if (dish.getCalories() <= 700) return CaloricLevel.NORMAL;
                            else return CaloricLevel.FAT;
                        } )
                )
        );
    }

    private static Map<Dish.Type, Long> countDishesInGroups() {
        return ExampleData.menu.stream().collect(Collectors.groupingBy(Dish::getType, Collectors.counting()));
    }

   
    private static Map<Dish.Type, Dish> mostCaloricDishesByType() {
        return ExampleData.menu.stream().collect(
        		Collectors.groupingBy(Dish::getType,
                		Collectors.collectingAndThen(
                        		Collectors.reducing((d1, d2) -> d1.getCalories() > d2.getCalories() ? d1 : d2),
                                Optional::get)));
    }

    private static Map<Dish.Type, Integer> sumCaloriesByType() {
        return ExampleData.menu.stream().collect(Collectors.groupingBy(Dish::getType,
        		Collectors.summingInt(Dish::getCalories)));
    }

    private static Map<Dish.Type, Set<CaloricLevel>> caloricLevelsByType() {
        return ExampleData.menu.stream().collect(
        		Collectors.groupingBy(Dish::getType, Collectors.mapping(
                        dish -> { if (dish.getCalories() <= 400) return CaloricLevel.DIET;
                        else if (dish.getCalories() <= 700) return CaloricLevel.NORMAL;
                        else return CaloricLevel.FAT; },
                        Collectors.toSet() )));
    }
}
