package com.dhruba.pluralsight.maps;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class StreamUtilForMaps {
	
	public static List<Person> readFile(String fileName) {
		
		List<Person> people = new ArrayList<>();
		try(
			BufferedReader reader = new BufferedReader(new InputStreamReader(StreamUtilForMaps.class.getResourceAsStream(fileName)));
			Stream<String> stream = reader.lines();
		){
			stream.map(line -> {
				String[] s = line.split(" ");
				Person p = new Person(Integer.parseInt(s[1].trim()), s[0].trim(), s[2].trim());
				people.add(p);
				return p;
			}).forEach(System.out::println)
			;
		} catch(IOException iex) {
			System.out.println(iex);
		}
		
		return people;
	}

}
