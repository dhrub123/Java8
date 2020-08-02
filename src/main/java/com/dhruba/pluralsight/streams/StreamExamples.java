package com.dhruba.pluralsight.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class StreamExamples {
	
	public static void main(String[] args) {
		
		List<Person> persons = new ArrayList<Person>();
		List<Person> duplicatePersons = new ArrayList<Person>();
		
		//Create a stream out of a list
		Stream<Person> peopleStream = persons.stream();
		
		
		//Create a consumer to add contents in another list
		Consumer<Person> additionConsumer = p -> duplicatePersons.add(p);
		//This can also be written as a method reference like
		additionConsumer = duplicatePersons::add;
		//Create a consumer to print 
		Consumer<Person> printConsumer = p -> System.out.println(p);
		//This can also be written as a method reference like
		printConsumer = System.out::println;
		
		//Pass the consumer to forEach() method of stream and chain with another consumer
		peopleStream.forEach(additionConsumer.andThen(printConsumer));
		
		//Filter
		List<Person> filteredPersons = new ArrayList<Person>();
		Stream<Person> filterStream = persons.stream();
		
		Predicate<Person> lowerAgePredicate = p -> p.getAge() > 20;
		Predicate<Person> upperAgePredicate = p -> p.getAge() < 50;
		
		filterStream
				.filter(lowerAgePredicate.and(upperAgePredicate))
				.forEach(filteredPersons::add);
		
		
	}
	
}
