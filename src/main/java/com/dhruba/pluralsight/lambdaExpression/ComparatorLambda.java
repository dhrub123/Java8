package com.dhruba.pluralsight.lambdaExpression;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComparatorLambda {
	
	public static void main(String[] args) {
		
		List<String> listOfStrings = Arrays.asList("*****","*","****","***");
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
	}
}
