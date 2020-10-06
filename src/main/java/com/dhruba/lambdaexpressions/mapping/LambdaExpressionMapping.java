package com.dhruba.lambdaexpressions.mapping;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class LambdaExpressionMapping {
	 
	public static void main(String[] args) {
		
		User sarah = new User("Sarah");
		User james = new User("James");
		User mary = new User("Mary");
		User tom = new User("Tom");
		
		List<User> users = new ArrayList<User>();
		users.add(sarah);users.add(james);
		users.add(mary);users.add(tom);
		
		//Function to get a name from user
		Function<User,String> getName = user -> user.getName();
		for(User user : users) {
			System.out.println(getName.apply(user));
		}
		
		users.stream().map(getName).forEach(System.out::println);
		
	}
	
}
