package com.dhruba.pluralsight.dateTime;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class StreamUtilForDateTime {
	
	public static List<Person> readFile(String fileName) {
		
		List<Person> people = new ArrayList<>();
		try(
			BufferedReader reader = new BufferedReader(new InputStreamReader(StreamUtilForDateTime.class.getResourceAsStream(fileName)));
			Stream<String> stream = reader.lines();
		){
			stream.map(line -> {
				String[] s = line.split(" ");
				int year = Integer.parseInt(s[1]);
				Month month = Month.of(Integer.parseInt(s[2]));
				int dayOfMonth = Integer.parseInt(s[3]);
				Person p = new Person(LocalDate.of(year, month, dayOfMonth),s[0].trim());
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
