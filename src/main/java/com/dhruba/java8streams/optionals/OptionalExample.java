package com.dhruba.java8streams.optionals;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class OptionalExample {

	public static void main(String[] args) {
		
		List<Double> result = new ArrayList<>();
		ThreadLocalRandom
				.current()
				.doubles(10_000)
				.boxed()
				.forEach(
						d -> NewMath.inv(d)
								.ifPresent(
									inv -> NewMath.sqrt(inv)
												  .ifPresent(
														sqrt -> result.add(sqrt)
												   )
								)
				);
		System.out.println("# result = " + result.size());
		
		System.out.println("-------------------");
		
		/*
		List<Double> paralleResult = new ArrayList<>();
		
		ThreadLocalRandom
		.current()
		.doubles(10_000)
		.boxed().parallel()
		.forEach(
				d -> NewMath.inv(d)
						.ifPresent(
							inv -> NewMath.sqrt(inv)
										  .ifPresent(
												sqrt -> paralleResult.add(sqrt)
										   )
						)
		);
		System.out.println("# paralleResult = " + paralleResult.size()); // we have issue because we are using sneaky race condition
		*/
		
		System.out.println("-------------------");
		
		Function<Double, Stream<Double>> flatmapper = 
				d -> NewMath.inv(d)
							.flatMap(inv -> NewMath.sqrt(inv))
							.map(sqrt -> Stream.of(sqrt))
							.orElseGet(() -> Stream.empty());
		
				
		List<Double> rightResult = ThreadLocalRandom
			.current()
			.doubles(10_000)
			.boxed()
			.flatMap(flatmapper)
			.collect(Collectors.toList());
		System.out.println("# rightResult = " + rightResult.size());
		
		System.out.println("-------------------");
		
		rightResult = ThreadLocalRandom
				.current()
				.doubles(10_000)
				.parallel()
				.map(d -> d*20 - 10) //some negative numbers
				.boxed()
				.flatMap(flatmapper)
				.collect(Collectors.toList());
		System.out.println("# rightResult in parallel = " + rightResult.size()); 
		//we should have less than 10000 because negative numbers were discarded
		
		System.out.println("-------------------");
	}

}
