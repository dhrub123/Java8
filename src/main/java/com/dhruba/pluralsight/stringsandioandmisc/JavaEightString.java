package com.dhruba.pluralsight.stringsandioandmisc;

import java.util.StringJoiner;
import java.util.stream.IntStream;

public class JavaEightString {
	
	public static void main(String[] args) {
		
		//Pre java 8
		String s  = "hello world";
		IntStream stream = s.chars();
		
		stream
			.mapToObj(letter -> (char)letter)
			.map(Character::toUpperCase)
			.forEach(System.out::print);
		
		String s1 = "hello", s2 = "world";
		s = s1 + " " + s2;//inefficient
		System.out.println();
		System.out.println(s);
		
		//introduction of string buffer
		StringBuffer sb1 = new StringBuffer();//but this is thread safe so ineficient
		sb1.append("hello").append(" ").append("world");
		System.out.println(sb1.toString());
		
		//introduction of stringbuilder in JDK5 which is not synchronized
		StringBuilder sb2 = new StringBuilder();
		sb2.append("hello").append(" ").append("world");
		System.out.println(sb2.toString());
		
		//JDK8
		StringJoiner sj = new StringJoiner(", ","[","]");//the constructor takes a separator, a prefix or a postfix
		sj.add("one").add("two").add("three");
		System.out.println(sj.toString());
		
		//We can also use string joiner from string class
			//varargs
			s = String.join(",", "one","two","three","four");
			System.out.println(s);
			//iterable
			String[] sarray = {"one","two","three","four"};
			s=String.join("-",sarray);
			System.out.println(s);
	}
}
