package com.dhruba.pluralsight.dateTime;

import java.time.LocalDate;

public class Person {
	
	private LocalDate birthDate;
	
	private String name;
	
	public Person() {}

	public Person(LocalDate birthDate, String name) {
		this.birthDate = birthDate;
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}

	@Override
	public String toString() {
		return "Person [birthDate=" + birthDate + ", name=" + name + "]";
	}
	
}
