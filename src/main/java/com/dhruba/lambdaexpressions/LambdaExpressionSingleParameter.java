package com.dhruba.lambdaexpressions;

public class LambdaExpressionSingleParameter {
	public static void main(String[] args) {
		/*
		 * This is also an example of a lambda expression
		 * with one argument
		 */
		Sayable sayable = (name) -> {
			return "Hello, " + name;
		};
		System.out.println(sayable.say("Dhruba"));
		
		/**
		 * Function parenthesis can also be omitted
		 */
		Sayable said = name -> {
			return "Hello, " + name;
		};
		System.out.println(said.say("Dhruba"));
		
	}
}
