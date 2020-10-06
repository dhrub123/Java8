package com.dhruba.lambdaexpressions.chaining;

import java.util.function.Consumer;
import java.util.function.Predicate;

public class LambdaChaining {
	
	public static void main(String[] args) {
		Consumer<String> c1 = s -> System.out.println("c1 consumes " + s);
		Consumer<String> c2 = s -> System.out.println("c2 consumes " + s);
		
		c1.accept("Hello");
		c2.accept("Hello");
		
		System.out.println("==================");
		
		Consumer<String> c3 = s -> {
			c1.accept(s);
			c2.accept(s);
		};
		
		c3.accept("Hello");
		
		System.out.println("==================");
		c3 = c1.andThen(c2);//This is a default method in Consumer Functional Interface
		c3.accept("Hello");
		
		
		System.out.println("==================");
		
		Predicate<String> isNull = s -> s== null;
		System.out.println("For Null = " + isNull.test(null));
		System.out.println("For Hello = " + isNull.test("Hello"));
		
		System.out.println("==================");
		
		Predicate<String> isEmpty = s -> s.isEmpty();
		System.out.println("For Empty = " + isEmpty.test(""));
		System.out.println("For Hello = " + isEmpty.test("Hello"));

		System.out.println("==================");
		
		Predicate<String> isNeitherNullNorEmpty = isNull.negate().and(isEmpty.negate());
		System.out.println("For Null = " + isNeitherNullNorEmpty.test(null));
		System.out.println("For Empty = " + isNeitherNullNorEmpty.test(""));
		System.out.println("For Hello = " + isNeitherNullNorEmpty.test("Hello"));

		System.out.println("==================");
		
		
	}
}
