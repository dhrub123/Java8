package com.dhruba.lambdaexpressions;

import java.util.ArrayList;
import java.util.List;

public class LambdaExpressionForEach {
	public static void main(String[] args) {
		/*
		 * This is also an example of a lambda expression
		 * with loop
		 */
		List<String> nameList = new ArrayList<String>();
		nameList.add("Dhruba");
		nameList.add("Sandeep");
		nameList.add("Saurabh");
		nameList.add("Venkat");
		
		nameList.forEach(
			(n) -> {
				System.out.println(n);
				System.out.println(" looping");
			}	
		);
		
	}
}
