package com.dhruba.pluralsight.lambdaExpression;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.function.ToIntFunction;

public class ComparatorLambda {
	
	public static void main(String[] args) {
		
		List<String> listOfStrings = Arrays.asList("*****","*","****","***");
		List<Integer> listOfIntegers = Arrays.asList(1,2,3,4);
		List<String> listOfNumbersAsString = Arrays.asList("one","two","three","four","five","six","seven","eight","nine");
		//Implementation using anonymous class
		Comparator<String> comparator = new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return Integer.compare(o1.length(), o2.length());
			}
		};
		
		
		Collections.sort(listOfStrings,comparator);
		for(String s: listOfStrings) {
			System.out.println(s);
		}
		
		//Implementation using lambda
		Comparator<String> comparatorLambda = (String o1, String o2) -> Integer.compare(o1.length(), o2.length());
		Collections.sort(listOfStrings,comparatorLambda);
		for(String s: listOfStrings) {
			System.out.println(s);
		}
		
		//Implementation using lambda without parameter types
		Comparator<String> comparatorLambdaWithoutType = (o1, o2) -> Integer.compare(o1.length(), o2.length());
		Collections.sort(listOfStrings,comparatorLambdaWithoutType);
		for(String s: listOfStrings) {
			System.out.println(s);
		}
		
		//Implementation using lambda with method references
		Comparator<Integer> comparatorLambdaWithMethodReference = Integer::compare;
		Collections.sort(listOfIntegers,comparatorLambdaWithMethodReference);
		for(Integer i: listOfIntegers) {
			System.out.println(i);
		}
		
		//comparing list of number as strings
		Comparator<String> compareListOfNumbersAsStringbyAlphabeticalOrder = (s1,s2) -> s1.compareTo(s2);
		listOfNumbersAsString.sort(compareListOfNumbersAsStringbyAlphabeticalOrder);
		System.out.println(listOfNumbersAsString);// [eight, five, four, nine, one, seven, six, three, two] - these have
													// been sorted in alphabetical order 
		//compare shortest to longest
		Comparator<String> compareListOfNumbersAsStringByLength = (s1,s2) -> Integer.compare(s1.length(), s1.length());
		listOfNumbersAsString.sort(compareListOfNumbersAsStringByLength);
		System.out.println(listOfNumbersAsString);//[one, two, three, four, five, six, seven, eight, nine]
		
		//Bad Performance - Autoboxing
		Function<String,Integer> toLength = s -> s.length();
		compareListOfNumbersAsStringByLength= Comparator.comparing(toLength);
		listOfNumbersAsString.sort(compareListOfNumbersAsStringByLength);
		System.out.println(listOfNumbersAsString);//[one, two, three, four, five, six, seven, eight, nine]
		
		//Good Performance
		ToIntFunction<String> toLengthWithoutAutoBoxing = s -> s.length();
		compareListOfNumbersAsStringByLength= Comparator.comparingInt(toLengthWithoutAutoBoxing);
		listOfNumbersAsString.sort(compareListOfNumbersAsStringByLength);
		System.out.println(listOfNumbersAsString);//[one, two, three, four, five, six, seven, eight, nine]
		System.out.println("===============");
		//chaining comparators
		User sarah = new User("Sarah", 28);
		User james = new User("James", 35);
		User mary = new User("Mary", 33);
		User tom1 = new User("Tom1", 24);
		User tom2 = new User("Tom2", 25);
		
		List<User> users = Arrays.asList(sarah, james, mary, tom1, tom2);
		Comparator<User> userComparatorByName = Comparator.comparing(user -> user.getName());
		userComparatorByName = Comparator.comparing(User::getName);
		userComparatorByName = (user1, user2) -> user1.getName().compareTo(user2.getName());
		users.sort(userComparatorByName);
		users.forEach(System.out::println);
		System.out.println("===============");
		Comparator<User> userComparatorByAge = Comparator.comparing(user -> user.getAge());
		userComparatorByAge = Comparator.comparing(User::getAge);
		users.sort(userComparatorByAge);
		users.forEach(System.out::println);
		System.out.println("===============");
		Comparator<User> compareUsersBynameAndThenAge = userComparatorByName.thenComparing(userComparatorByAge);
		compareUsersBynameAndThenAge = Comparator.comparing(User::getName)
												 .thenComparing(User::getAge);
		users.sort(compareUsersBynameAndThenAge);
		users.forEach(System.out::println);
		System.out.println("===============");
		Comparator<User> compareUsersBynameAndThenAgeReversed = compareUsersBynameAndThenAge.reversed();
		users.sort(compareUsersBynameAndThenAgeReversed);
		users.forEach(System.out::println);
	}
}
