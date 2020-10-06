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
		
		//Filter with a predicate and loop with a consumer
		System.out.println("==================");
		List<String> stringsToFilter = new ArrayList<String>();
		stringsToFilter.add("one");stringsToFilter.add("two");stringsToFilter.add("three");
		stringsToFilter.add("four");stringsToFilter.add("five");
		Predicate<String> filter = (string) -> string.startsWith("t");
		stringsToFilter.removeIf(filter);
		
		stringsToFilter.forEach(string -> System.out.println(string));
		
		System.out.println("==================");
		Predicate<String> lengthCheckerLessThanTwenty = s -> s.length() < 20;
		Predicate<String> lengthCheckerGreaterThanFive = s -> s.length() > 5;
		Predicate<String> chainedAndPredicate = lengthCheckerLessThanTwenty
											.and(lengthCheckerGreaterThanFive);
		Predicate<String> chainedOrPredicate = lengthCheckerLessThanTwenty
				.or(lengthCheckerGreaterThanFive);
		System.out.println("Shorter than 20 characters = " + lengthCheckerLessThanTwenty.test("Pocha Dayita"));
		
		System.out.println(
				"Shorter than 20 characters but greater than 5 characters = " + chainedAndPredicate.test("Pocha Dayita"));
		System.out.println(
				"Shorter than 20 characters or greater than 5 characters = " + chainedOrPredicate.test("Pocha Dayita"));
		
		//static predicate method
		Predicate<String> stringEqualityComparator = Predicate.isEqual("Yes");
		System.out.println("String equal ? " + stringEqualityComparator.test("No"));
	}
}
