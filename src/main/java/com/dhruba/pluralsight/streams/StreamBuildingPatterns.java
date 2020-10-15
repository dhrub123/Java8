package com.dhruba.pluralsight.streams;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamBuildingPatterns {

	public static void main(String[] args) {

		List<Integer> ints = Arrays.asList(0, 1, 2, 3, 4);

		Stream<Integer> stream = ints.stream();
		Stream<Integer> stream1 = Stream.of(0, 1, 2, 3, 4) ;
		
		stream.forEach(System.out::print);
		System.out.println();
		stream1.forEach(System.out::print);
		
		System.out.println();
		//The following are all infinite streams. We have to limit them
		Stream<String> streamOfStrings = Stream.generate(() -> "one");
		streamOfStrings.limit(5).forEach(System.out::print);
		System.out.println();
		
		Stream<String> streamOfStrings2 = Stream.iterate("+", s -> s + "+");
		streamOfStrings2.limit(5).forEach(System.out::println);
		System.out.println();
		
		IntStream streamOfInt = ThreadLocalRandom.current().ints();
		streamOfInt.limit(5).forEach(System.out::print);
		System.out.println();
		
	}

}
