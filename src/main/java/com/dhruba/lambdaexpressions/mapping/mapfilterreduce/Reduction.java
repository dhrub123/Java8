package com.dhruba.lambdaexpressions.mapping.mapfilterreduce;

import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;

public class Reduction {

	public static void main(String[] args) {
		
		List<Integer> ints = Arrays.asList(0,1,2,3,4,5,6,7,8,9);
		List<Integer> ints1 = Arrays.asList(0,1,2,3,4);
		List<Integer> ints2 = Arrays.asList(5,6,7,8,9);
		
		List<Integer> ints3 = Arrays.asList(0,1,2,3,4,-1,-2,-3,-4);
		List<Integer> ints4 = Arrays.asList(-1,-2,-3,-4);
		
		System.out.println("---SUMMATION---ASSOCIATIVE");
		BinaryOperator<Integer> op = (i1,i2) -> i1+i2;
		int reduction = reduce(ints, 0, op);
		System.out.println("Reduction : " + reduction);
		
		//simulate parallel reduction
		int reduction1 = reduce(ints1, 0, op);
		int reduction2 = reduce(ints2, 0, op);
		int reduction3 = reduce(Arrays.asList(reduction1,reduction2),0,op);
		System.out.println("Parallel Reduction : " + reduction3);
		
		System.out.println("---MAX---ASSOCIATIVE");
		op = (i1,i2) -> Integer.max(i1, i2);
		reduction = reduce(ints, 0, op);
		System.out.println("Reduction : " + reduction);
		reduction1 = reduce(ints1, 0, op);
		reduction2 = reduce(ints2, 0, op);
		reduction3 = reduce(Arrays.asList(reduction1,reduction2),0,op);
		System.out.println("Parallel Reduction : " + reduction3);
		
		reduction = reduce(ints3, 0, op);
		System.out.println("Negative Max Reduction : " + reduction);
		
		reduction1 = reduce(ints1, 0, op);
		reduction2 = reduce(ints4, 0, op);
		System.out.println("Max Reduction of (-1,-2,-3,-4) : " + reduction2); //This comes as 0
		// so if we have positive values , we will be fine but else for only negative elements, it will be wrong result
		reduction3 = reduce(Arrays.asList(reduction1,reduction2),0,op);
		System.out.println("Parallel Negative Max Reduction : " + reduction3);
		
		System.out.println("---(a+b)^2---NON-ASSOCIATIVE OPERATION, FALSE RESULT");
		op = (i1,i2) -> (i1+i2) * (i1+i2);
		reduction = reduce(ints, 0, op);
		System.out.println("Reduction : " + reduction);
		reduction1 = reduce(ints1, 0, op);
		reduction2 = reduce(ints2, 0, op);
		reduction3 = reduce(Arrays.asList(reduction1,reduction2),0,op);
		System.out.println("Parallel Reduction : " + reduction3);
		
		System.out.println("---Return first element of List---ASSOCIATIVE");
		op = (i1,i2) -> i1;
		reduction = reduce(ints, 0, op);
		System.out.println("Reduction : " + reduction);
		reduction1 = reduce(ints1, 0, op);
		reduction2 = reduce(ints2, 0, op);
		reduction3 = reduce(Arrays.asList(reduction1,reduction2),0,op);
		System.out.println("Parallel Reduction : " + reduction3);
		
		System.out.println("---(a+b)/2---NON-ASSOCIATIVE OPERATION, FALSE RESULT");
		op = (i1,i2) -> (i1+i2)/2;
		reduction = reduce(ints, 0, op);
		System.out.println("Reduction : " + reduction);
		reduction1 = reduce(ints1, 0, op);
		reduction2 = reduce(ints2, 0, op);
		reduction3 = reduce(Arrays.asList(reduction1,reduction2),0,op);
		System.out.println("Parallel Reduction : " + reduction3);
	}

	private static int reduce(
			List<Integer> values, 
			int valueIfEmpty, 
			BinaryOperator<Integer> reduction) {
		
		int result = valueIfEmpty;
		for(int value : values) {
			result = reduction.apply(result, value);
		}
		return result;
	}

}
