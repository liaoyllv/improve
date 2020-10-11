package com.yukon.chap5;

import com.yukon.chap4.Dish;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static com.yukon.chap4.Dish.menu;
import static java.util.stream.Collectors.toList;

public class Filtering {

    public static void main(String... args) {

        // Filtering with predicate
        List<Dish> vegetarianMenu = menu.stream()
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
                menu.stream()
                        .filter(d -> d.getCalories() < 400)
                        .limit(2)
                        .collect(toList());
        dishesLimit3.stream().map(Dish::getCalories).forEach(System.out::println);

        menu.stream().sorted(Comparator.comparing(Dish::getCalories)).forEach(d -> System.out.println(d.getCalories()));

        // Skipping elements
        List<Dish> dishesSkip2 =
                menu.stream()
                        .filter(d -> d.getCalories() > 300)
                        .skip(2)
                        .collect(toList());
        dishesSkip2.forEach(System.out::println);
    }
}
