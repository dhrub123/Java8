package com.dhruba.pluralsight.maps;

public class Person {
	
	private int age;
	private String name;
	private String gender;
	
	public Person() {}

	public Person(int age, String name, String gender) {
		this.age = age;
		this.name = name;
		this.gender = gender;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String toString() {
		return "Person [age=" + age + ", name=" + name + ", gender=" + gender + "]";
	}
	
}
