package com.dhruba.lambdaexpressions;

public class LambdaExpressionMultipleParameter {
	public static void main(String[] args) {
		/*
		 * This is also an example of a lambda expression
		 * with multiple arguments
		 */
		Addable addable = (a,b) -> {
			return a + b;
		};
		System.out.println(addable.add(3,4));
		
	}
}
