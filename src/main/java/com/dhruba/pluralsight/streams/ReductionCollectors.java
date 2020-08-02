package com.dhruba.pluralsight.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ReductionCollectors {
	public static void main(String[] args) {
		
		List<String> listOfIntegers = Arrays.asList("one","two","three","four","five");
		//collected in a string 
		String collectedString = 
		  listOfIntegers.stream()
						.filter(i -> i.length() > 3)//filtered by a predicate
						.collect(Collectors.joining(" ,")); // joined in a string separated by comma
		System.out.println(collectedString);
		
		//collected in a list 
		List<String> collectedList = 
		  listOfIntegers.stream()
						.filter(i -> i.length() > 3)//filtered by a predicate
						.collect(Collectors.toList()); // joined in a string separated by comma
		collectedList.stream().forEach(System.out::println);
	}
}
