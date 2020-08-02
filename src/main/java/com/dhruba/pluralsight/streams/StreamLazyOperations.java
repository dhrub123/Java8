package com.dhruba.pluralsight.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class StreamLazyOperations {
	
	public static void main(String[] args) {
		List<Person> persons = new ArrayList<Person>();
		List<Person> filteredPersons = new ArrayList<Person>();
		Predicate<Person> lowerAgePredicate = p -> p.getAge() > 20;
		Stream<Person> filteredStream = persons.stream()
													.peek(System.out::println)//Lazy method - No Data operations performed
													.filter(lowerAgePredicate)//Lazy method - No Data operations performed
													.peek(filteredPersons::add)//Lazy method - No Data operations performed
													;

	}
	
}
