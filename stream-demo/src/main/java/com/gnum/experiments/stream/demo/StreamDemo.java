/*
 * Globalroam 2015 @copyright
 */
package com.gnum.experiments.stream.demo;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

/**
 * @author chenglong
 * @description
 */
public class StreamDemo {
    public static void main(String[] args) throws InterruptedException {
//        testStream();
//        test();
//        System.gc();
//        Thread.sleep(1000000);
//        testStreamFilter();
//        testFilterUniqueElement();
//        testSkipElement();
//        testFilterFirstTwoMeat();
//        testMap2ExtractName();
//        testMap2ExtractName1();
//        testFlatMapMethod();
//        testMap();
//        testFlatMap();
//        testAnyMatch();
//        testAllMatch();
//        testFindAny();
//        testGetMax();
        testCountDishes();

    }


    public static void testStream() {
        List<Dish> menu = createDishes();
        List<String> highCaloricDishes = menu.stream()
                .filter(d -> d.getCalories() > 300)
                .map(Dish::getName)
                .limit(3)
                .collect(toList());
        System.out.println(highCaloricDishes);
    }

    public static List<Dish> createDishes() {
        return Arrays.asList(
                new Dish("pork", false, 800, Dish.Type.MEAT),
                new Dish("beef", false, 700, Dish.Type.MEAT),
                new Dish("chicken", false, 400, Dish.Type.MEAT),
                new Dish("french fries", true, 530, Dish.Type.OTHER),
                new Dish("rice", true, 350, Dish.Type.OTHER),
                new Dish("season fruit", true, 120, Dish.Type.OTHER),
                new Dish("pizza", true, 550, Dish.Type.OTHER),
                new Dish("prawns", false, 300, Dish.Type.FISH),
                new Dish("salmon", false, 450, Dish.Type.FISH));
    }

    public static void test() {
        new Dish("test", false, 100, Dish.Type.FISH);
    }

    public static void testStreamFilter() {
        List<Dish> dishes = createDishes();
        List<Dish> vegetarianDishes = dishes.stream().filter(Dish::isVegetarian).collect(toList());
        System.out.println(vegetarianDishes);
    }

    public static void testFilterUniqueElement() {
        List<Integer> numbers = Arrays.asList(1, 2, 1, 3, 3, 2, 4);
        numbers.stream()
                .filter(i -> i % 2 == 0)
                .distinct()
                .forEach(System.out::println);
    }

    public static void testSkipElement() {
        List<Dish> menu = createDishes();
        List<Dish> dishes = menu.stream()
                .filter(d -> d.getCalories() > 300)
                .skip(2)
                .collect(toList());
        System.out.println(dishes);
    }

    public static void testFilterFirstTwoMeat() {
        List<Dish> menu = createDishes();
        List<Dish> firstTwoMeat = menu.stream().filter(d -> d.getType() == Dish.Type.MEAT).limit(2).collect(toList());
        System.out.println(firstTwoMeat);
    }

    public static void testMap2ExtractName() {
        List<Dish> menu = createDishes();
        List<String> dishNames = menu.stream()
                .map(Dish::getName)
                .collect(toList());
        System.out.println(dishNames);
    }

    public static void testMap2ExtractName1() {
        List<String> words = Arrays.asList("Java8", "Lambdas", "In", "Action");
        List<Integer> wordLengths = words.stream()
                .map(String::length)
                .collect(toList());
        System.out.println(wordLengths);
    }

    public static void testFlatMapMethod() {
        List<String> words = Arrays.asList("hello", "world");
        List<String> uniqeWords = words.stream()
                .map(w -> w.split(""))
                .flatMap(Arrays::stream)
                .distinct()
                .collect(toList());
        System.out.println(uniqeWords);
    }

    public static void testMap() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> sqrtNumbers = numbers.stream()
                .map(n -> n * n)
                .collect(toList());
        System.out.println(sqrtNumbers);
    }

    public static void testFlatMap() {
        List<Integer> numbers1 = Arrays.asList(1, 2, 3);
        List<Integer> numbers2 = Arrays.asList(3, 4);
        List<int[]> pairs =
                numbers1.stream()
                        .flatMap(i -> numbers2.stream()
                                        .filter(j -> (i + j) % 3 == 0)
                                        .map(j -> new int[]{i, j})
                        )
                        .collect(toList());
        pairs.stream()
                .forEach(p -> System.out.println(Arrays.toString(p)));
    }

    public static void testAnyMatch() {
        List<Dish> dishes = createDishes();
        boolean isVegetarian = dishes.stream()
                .anyMatch(Dish::isVegetarian);
        System.out.println("this menu is somewhat vegetarian!");
    }

    public static void testAllMatch() {
        List<Dish> dishes = createDishes();
        boolean isLowCalories = dishes.stream()
                .allMatch(d -> d.getCalories() < 1000);
        if (isLowCalories) {
            System.out.println("this menu is all low calories dishes!");

        } else {
            System.out.println("this menu contains some high calories dishes");

        }

    }

    public static void testFindAny() {
        List<Dish> dishes = createDishes();
        dishes.stream()
                .filter(Dish::isVegetarian)
                .findAny()
                .ifPresent(System.out::println);
    }

    public static void testGetMax() {
        List<Integer> list = Arrays.asList(2, 4, 1, 6, 9);
        Optional<Integer> reduce = list.stream()
                .reduce(Integer::max);
        System.out.println(reduce.get());
    }

    public static void testCountDishes() {
        List<Dish> dishes = createDishes();
        Integer dishCount = dishes.stream()
                .map(dish -> 1)
                .reduce(0, (x, y) -> x + y);
        System.out.println("the total dish count is ==>"+dishCount);
    }
}
