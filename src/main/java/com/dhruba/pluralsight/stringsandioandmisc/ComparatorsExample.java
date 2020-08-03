package com.dhruba.pluralsight.stringsandioandmisc;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

import com.dhruba.pluralsight.streams.Person;

public class ComparatorsExample {
	
	public static void main(String[] args) {
		
		List<Person> people = ComparatorsExample.readFiles();
		
		//JDK7 way
		Comparator<Person> compareName = new Comparator<Person>() {
			
			@Override
			public int compare(Person o1, Person o2) {
				return o1.getName().compareTo(o2.getName());
			}
		};
		
		people.sort(compareName);
		System.out.println(people);
		
		//JDK8 way
		Comparator<Person> compareName8 = Comparator.comparing(Person::getName);
		people.sort(compareName8);
		System.out.println(people);
		
		//JDK 7 way of chaining comparators
		Comparator<Person> compareNameThenAge = new Comparator<Person>() {
			
			@Override
			public int compare(Person o1, Person o2) {
				int nameComparison = o1.getName().compareTo(o2.getName());
				return nameComparison == 0 ? (o1.getAge() - o2.getAge()) : nameComparison;
			}
		};
		
		people.sort(compareNameThenAge);
		System.out.println(people);
		
		//JDK8 way
		compareName8 = Comparator.comparing(Person::getName).thenComparing(Person::getAge);
		people.sort(compareName8);
		System.out.println(people);
		
		//reverse comparison JDK8
		Comparator<Person> compareNameReversed = compareName8.reversed();
		people.sort(compareNameReversed);
		System.out.println(people);
		
		//null first and last
		Comparator.nullsFirst(Comparator.naturalOrder());
		Comparator.nullsLast(Comparator.naturalOrder());
	}
	
	public static List<Person> readFiles() {
		
		Path path = Paths.get("/Users/dhruba/git/Java8/src/main/java/com/dhruba/pluralsight/stringsandioandmisc/people.txt");
		List<Person> people = new ArrayList<>();
		try(
			Stream<String> stream = Files.lines(path);//This is new In Java 8
			
			
		){
			stream.map(
				s -> {
					String[] strings = s.split(" ");
					Person p = new Person(Integer.parseInt(strings[1].trim()),strings[0].trim());
					return p;
				}
			).forEach(people::add);
			
		}catch(IOException iex) {
			
		}
		return people;
		
	}
}
