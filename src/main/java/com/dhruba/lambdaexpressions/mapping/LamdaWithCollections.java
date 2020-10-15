package com.dhruba.lambdaexpressions.mapping;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LamdaWithCollections {
	
	public static void main(String[] args) {
		
		Person p1 = new Person("Alice", 23);
		Person p2 = new Person("Brian", 56);
		Person p3 = new Person("Chelsea", 46);
		Person p4 = new Person("David", 28);
		Person p5 = new Person("Erica", 37);
		Person p6 = new Person("Francisco", 18);
		
		List<Person> people = new ArrayList<>(Arrays.asList(p1,p2,p3,p4,p5,p6));
		
		people.forEach(person -> System.out.println(person));
		
		people.removeIf(person -> person.getAge()<30);
		
		System.out.println("-----");
		people.forEach(System.out::println);
		
		people.replaceAll(person -> new Person(person.getName().toUpperCase(), person.getAge()));
		
		System.out.println("-----");
		people.forEach(System.out::println);
		
		people.sort(Comparator.comparing(Person::getAge));
		
		System.out.println("-----");
		people.forEach(System.out::println);
		
		people.sort(Comparator.comparing(Person::getAge).reversed());
		
		System.out.println("-----");
		people.forEach(System.out::println);
		
		
		people = new ArrayList<>(Arrays.asList(p1,p2,p3,p4,p5,p6));
		
		City newYork = new City("New York");
		City shanghai = new City("Shanghai");
		City paris = new City("Paris");
		
		Map<City, List<Person>> map = new HashMap<>();
		
		System.out.println("-----");
		System.out.println("People from Paris : " + map.get(paris));
		
		System.out.println("-----");
		System.out.println("People from Paris : " + map.getOrDefault(paris, Collections.EMPTY_LIST));
		
		System.out.println("-----");
		map.putIfAbsent(paris, new ArrayList<>());
		map.get(paris).add(p1);
		System.out.println("People from Paris : " + map.get(paris));
		
		System.out.println("-----");
		map.computeIfAbsent(newYork, city -> new ArrayList<>()).add(p2);
		map.computeIfAbsent(newYork, city -> new ArrayList<>()).add(p3);
		System.out.println("People from New York : " + map.get(newYork));
		
		System.out.println("-----");
		
		Map<City, List<Person>> map1 = new HashMap<>();
		
		System.out.println("Map1 contents ");
		map1.computeIfAbsent(newYork, city -> new ArrayList<>()).add(p1);
		map1.computeIfAbsent(shanghai, city -> new ArrayList<>()).add(p2);
		map1.computeIfAbsent(shanghai, city -> new ArrayList<>()).add(p3);
		map1.forEach((city, folksFromM1) -> System.out.println(city + " : " + folksFromM1));
		System.out.println("-----");
		
		Map<City, List<Person>> map2 = new HashMap<>();
		
		System.out.println("Map2 contents ");
		map2.computeIfAbsent(shanghai, city -> new ArrayList<>()).add(p4);
		map2.computeIfAbsent(paris, city -> new ArrayList<>()).add(p5);
		map2.computeIfAbsent(paris, city -> new ArrayList<>()).add(p6);
		map2.forEach((city, folksFromM2) -> System.out.println(city + " : " + folksFromM2));
		
		System.out.println("-----");
		System.out.println("Merged map contents ");
		map2.forEach(
				(city, persons) -> {
					map1.merge(
							city, persons, (peopleFromMap1, peopleFromMap2) -> {
								peopleFromMap1.addAll(peopleFromMap2);
								return peopleFromMap1;
							});
				}
		);
		map1.forEach((city, folksFromM1) -> System.out.println(city + " : " + folksFromM1));
		System.out.println("-----");
	}
}
