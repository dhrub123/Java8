package com.dhruba.pluralsight.lambdaExpression;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComparatorLambda {
	
	public static void main(String[] args) {
		
		List<String> listOfStrings = Arrays.asList("*****","*","****","***");
		List<Integer> listOfIntegers = Arrays.asList(1,2,3,4);
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
	}
}
