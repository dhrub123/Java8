package com.dhruba.pluralsight.streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.stream.Stream;

public class ReductionAggregations {
	
	public static void main(String[] args) {
		
		List<Integer> listOfIntegers = Arrays.asList(1,2,3,4);
		//identity element
		int id = 0;
		int reductionResult = 0;
		//Create Binary operation for reduction sum
		BinaryOperator<Integer> sum = (a1,a2) -> a1 + a2;
		
		//This can also be written as a methodReference
		sum = Integer::sum;
		//Create Binary operation for reduction max
		BinaryOperator<Integer> max = Integer::max;
		
		//reduction(sum) of a stream of 4 integers
		reductionResult = listOfIntegers.stream().reduce(id,sum);
		System.out.println(reductionResult);
		
		//reduction(sum) of an empty stream
		Stream<Integer>  emptyStream = Stream.empty();
		reductionResult = emptyStream.reduce(id,sum);
		System.out.println(reductionResult);
					
		//reduction(sum) of a stream of 1 element
		Stream<Integer>  oneElementStream = Arrays.asList(1).stream();
		reductionResult = oneElementStream.reduce(id,sum);
		System.out.println(reductionResult);
		
		//reduction(max) of a stream of 4 integers
		Optional<Integer> reductionResultOptional = listOfIntegers.stream().reduce(max);
		//System.out.println(reductionResultOptional.get());
		System.out.println(reductionResultOptional.orElse(0).toString());
		
		//reduction(sum) of an empty stream
		emptyStream = Stream.empty();
		reductionResultOptional = emptyStream.reduce(max);
		System.out.println(reductionResultOptional.orElse(0).toString());
		
		//optionalreturning reduction operations
		emptyStream = Stream.empty();
		reductionResultOptional = emptyStream.max(Comparator.naturalOrder());
		System.out.println(reductionResultOptional.orElse(0).toString());
		
		Optional<Integer> minValue = listOfIntegers.stream().min(Comparator.naturalOrder());
		System.out.println(minValue.get());
	}

}
