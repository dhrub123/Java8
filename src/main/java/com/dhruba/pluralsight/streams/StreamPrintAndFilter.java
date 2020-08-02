package com.dhruba.pluralsight.streams;

import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class StreamPrintAndFilter {
	
	public static void main(String[] args) {
		
		Stream<String> streamOfStrings = Stream.of("one","two","three","four","five");
		
		Consumer<String> printConsumer = p -> System.out.println(p);
		Predicate<String> lengthPredicate = p -> p.length() > 3 ;
		Predicate<String> equalityPredicateTwo = Predicate.isEqual("two");
		Predicate<String> equalityPredicateThree = Predicate.isEqual("three");
		
		//Nothing executed here
		streamOfStrings
		.filter(equalityPredicateTwo.or(equalityPredicateThree))
		.peek(printConsumer);
		
		streamOfStrings = Stream.of("one","two","three","four","five");
		//This is a final operation because we are using forEach
		streamOfStrings
					.filter(equalityPredicateTwo.or(equalityPredicateThree))
					.forEach(printConsumer);
	}

}
