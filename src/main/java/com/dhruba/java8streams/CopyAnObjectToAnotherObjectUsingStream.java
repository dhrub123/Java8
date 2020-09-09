package com.dhruba.java8streams;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CopyAnObjectToAnotherObjectUsingStream {
	
	static class Person{
		String name,age;
		

		public Person(String name, String age) {
			this.name = name;
			this.age = age;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getAge() {
			return age;
		}

		public void setAge(String age) {
			this.age = age;
		}
		
	}
	
	static class Alien{
		String name,age;
		

		public Alien(String name, String age) {
			this.name = name;
			this.age = age;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getAge() {
			return age;
		}

		public void setAge(String age) {
			this.age = age;
		}

		@Override
		public String toString() {
			return "Alien [name=" + name + ", age=" + age + "]";
		}
		
	}
	
	public static List<Person> generatePerson() {
		
		List<Person> people = new ArrayList<Person>();
		for(int i = 0 ; i<100; i++) {
			people.add(new Person("Person"+i,i+10+""));
		}
		return people;
		
	}
	public static void main(String[] args) {
		
		//Approach1
		List<Alien> aliens = new ArrayList<Alien>();
		List<Person> people = generatePerson();
		people
			.stream()
			.forEach(person -> {
				aliens.add(new Alien(person.getName(),person.getAge()));
			});
		//aliens.stream().forEach(a -> System.out.println(a));
		
		//Approach2
		List<Alien> newAliens = people.stream().map(convertFromPersonToAlien).collect(Collectors.<Alien> toList());
		newAliens.stream().forEach(a -> System.out.println(a));
		
	}
	
	static Function<Person, Alien> convertFromPersonToAlien = new Function<Person, Alien>() {

		@Override
		public Alien apply(Person person) {
			return new Alien(person.getName(), person.getAge());
		}
	};

}
