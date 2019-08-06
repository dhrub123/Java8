package com.dhruba.java8stringjoiners;

import java.util.StringJoiner;

public class StringJoinerExample {
	public static void addNames(StringJoiner joiner) {
		joiner.add("Dhruba");
		joiner.add("Dayita");
		joiner.add("Ghotu");
		joiner.add("Golu");
		System.out.println(joiner);
	}
	
	public static void main(String[] args) {
		
		//Limiting elements by a comma
		StringJoiner joiner = new StringJoiner(",");
		addNames(joiner);
		
		//Add prefix [ and Suffix ]
		joiner = new StringJoiner(",", "[", "]");
		addNames(joiner);
		
		//merge
		StringJoiner joiner1 = new StringJoiner(":", "[", "]");
		joiner1.add("Bua");
		joiner1.add("Titir");
		
		StringJoiner merge = joiner.merge(joiner1);
		System.out.println(merge);
	}
}
