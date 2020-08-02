package com.dhruba.pluralsight.streams;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Stream;

public class MapAndFlatMaps {
	
	public static void main(String[] args) {
		
		List<Integer> list1 = Arrays.asList(1,2,3,4,5,6,7);
		List<Integer> list2 = Arrays.asList(2,4,6);
		List<Integer> list3 = Arrays.asList(3,5,7);
		
		List<List<Integer>> listOfIntegerlists = Arrays.asList(list1,list2,list3);
		
		//print 3 lists
		listOfIntegerlists
						.stream()
						.forEach(System.out::println);
		
		//print size of 3 lists
		listOfIntegerlists
						.stream()
						.map(l -> l.size())
						.forEach(System.out::println);
		
		//print size of 3 lists using function
		Function<List<?>, Integer> listSizeFunction = List::size;
		listOfIntegerlists
						.stream()
						.map(listSizeFunction)
						.forEach(System.out::println);
		
		//function for flatmapper
		Function<List<Integer>, Stream<Integer>> flatmapFunction = l -> l.stream();
		
		//when we use a flatmap function with a map() function, 
		//it is going to print out address of streams
		listOfIntegerlists
						.stream()
						.map(flatmapFunction)
						.forEach(System.out::println);
		
		//when we use a flatmap function with a flatmap() function, 
		//it will flatten the streams of streams to a single stream
		listOfIntegerlists
						.stream()
						.flatMap(flatmapFunction)
						.forEach(System.out::println);
		
		
	}

}
