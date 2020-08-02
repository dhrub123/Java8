package com.dhruba.pluralsight.streams;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class StreamUtil {
	
	public static List<Person> readFile() {
		
		List<Person> people = new ArrayList<>();
		try(
			BufferedReader reader = new BufferedReader(new InputStreamReader(StreamUtil.class.getResourceAsStream("people.txt")));
			Stream<String> stream = reader.lines();
		){
			stream.map(line -> {
				String[] s = line.split(" ");
				Person p = new Person(Integer.parseInt(s[1]),s[0].trim());
				people.add(p);
				return p;
			}).forEach(System.out::println);
		} catch(IOException iex) {
			System.out.println(iex);
		}
		
		return people;
	}

}
