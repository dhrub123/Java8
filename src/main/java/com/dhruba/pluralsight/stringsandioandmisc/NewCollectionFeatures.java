package com.dhruba.pluralsight.stringsandioandmisc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class NewCollectionFeatures {
	
	public static void main(String[] args) {
		
		List<String> strings = Arrays.asList("one","two","three","four");
		strings.stream().spliterator().forEachRemaining(System.out::println);//Added stream() , spliterator() and forEach()
		strings.parallelStream().spliterator().forEachRemaining(System.out::println);//added parallelStream()
		
		//Added removeIf(), replaceAll() and sort() in List
		//boolean b = strings.removeIf(s -> s.length()>4);//only if immutable, this will give error
		List<String> listOfStrings = new ArrayList<String>(strings);
		System.out.println(listOfStrings.removeIf(s -> s.length()>4));
		System.out.println(listOfStrings.stream().collect(Collectors.joining(",")));
		
		listOfStrings.replaceAll(s -> s.toUpperCase());
		System.out.println(listOfStrings.stream().collect(Collectors.joining("-")));
		
		listOfStrings.sort(Comparator.naturalOrder());
		System.out.println(listOfStrings.stream().collect(Collectors.joining(", ")));
	}
}
