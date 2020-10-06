package com.dhruba.lambdaexpressions.firstlambda;

import java.util.function.Consumer;
import java.util.function.Supplier;

public class FirstLamdaExamples {
	
	
	public static void main(String[] args) {
		
		//Here the supplier is a functional interface
		/**
		 * 
		 @FunctionalInterface
			public interface Supplier<T> {
			
			    
			    T get();
			}
		 */
		//It has only one method, get() which returns the type passed
		Supplier<String> supplier = () -> "Hello!";
		
		//or
		
		supplier = () -> {
			return "Hello!";
		};
		
		//so to invoke it, we need to call get and assign it to a string since that is what it returns
		String hello = supplier.get();
		System.out.println(hello);
		
		//multiline lambda
		Consumer<String> consumer = (String t) -> {
			System.out.println("Print in consumer " + t);
		};
		consumer.accept("hello");
		
		//So look at the functional interface to get the information about the method to invoke 
		//and the return types and arguments and implementation 
		
		
		
	}
}
