package com.dhruba.pluralsight.lambdaExpression;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class PredicateChaining {
	
	public static void main(String[] args) {
		
		List<String> strings = Arrays.asList("one", "two", "three", "four", "five");
		List<String> result = new ArrayList<String>();
		
		Consumer<String> c1 = System.out::println;
		Consumer<String> c2 = result::add;
		
		strings.forEach(c1.andThen(c2));
		System.out.println("Size of Result = " + result.size());
		
		//Add for each to iterate
		strings.forEach(System.out::println);
		result.forEach(System.out::println);
		
		strings.forEach(String -> System.out.println(String));
		result.forEach(String -> System.out.println(String));
		
		String testString = "Horatioseventeen";
		//Predicates
		Predicate<String> p1 = s -> s.length() < 20;
		Predicate<String> p2 = s -> s.length() > 10;
		Predicate<String> p3 = p1.and(p2);
		System.out.println(p3.test(testString));
	}
}
