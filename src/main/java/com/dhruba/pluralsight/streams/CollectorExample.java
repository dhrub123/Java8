package com.dhruba.pluralsight.streams;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class CollectorExample {
	
	public static void main(String[] args) {
		
		List<Person> people = StreamUtil.readFile("people.txt");
		//Stream<Person> peopleStream = people.stream();
		
		//Youngest person in list older than 20
		Optional<Person> minAgeGreaterThan20 =
				people.stream()
				.filter(p -> p.getAge() >= 20)
				.min(Comparator.comparing(Person::getAge));
		System.out.println(minAgeGreaterThan20);
		
		//This will throw error because we cannot call 2 final operations upon one stream
		//Max Age in list
		/*Optional<Person> maxAge =
		peopleStream
				.max(Comparator.comparing(Person::getAge));
		System.out.println(maxAge);*/
		
		//Max Age in list
		Optional<Person> maxAge =
		people.stream()
				.max(Comparator.comparing(Person::getAge));
		System.out.println(maxAge);
		
		//Collectors
		Map<Integer, List<Person>> peopleMap = 
				people.stream()
				.collect(
						Collectors
							.groupingBy(Person::getAge)
						);
		System.out.println(peopleMap);
		
		//Collectors Post Processing
		Map<Integer, Long> postProcessedMap = 
				people.stream()
				.collect(
						Collectors
							.groupingBy(
									Person::getAge,
									Collectors.counting()//downstream collector
									)
						);
		System.out.println(postProcessedMap);
		
		//Collectors Post Processing
		Map<Integer, List<String>> postProcessedMapWithNamesGroupedByAges = 
				people.stream()
				.collect(
						Collectors
							.groupingBy(
									Person::getAge,
									Collectors.mapping(Person::getName, 
													   Collectors.toList()//Downstream collector
													)
									)
						);
		System.out.println(postProcessedMapWithNamesGroupedByAges);
		
		//Collectors Post Processing
		Map<Integer, Set<String>> postProcessedMapWithNamesSortedGroupedByAges = 
				people.stream()
				.collect(
						Collectors
							.groupingBy(
									Person::getAge,
									Collectors.mapping(Person::getName, 
													   Collectors.toCollection(TreeSet::new)//Downstream collector
											)
									)
						);
		System.out.println(postProcessedMapWithNamesSortedGroupedByAges);
		
		//Collectors Post Processing
		Map<Integer, String> postProcessedMapWithNamesGroupedByAgesInAString = 
				people.stream()
				.collect(
						Collectors
							.groupingBy(
									Person::getAge,
									Collectors.mapping(Person::getName, 
													   Collectors.joining(" , ")//Downstream collector
											)
									)
						);
		System.out.println(postProcessedMapWithNamesGroupedByAgesInAString);
	}

}
