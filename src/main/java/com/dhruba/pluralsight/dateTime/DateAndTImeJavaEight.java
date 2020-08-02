package com.dhruba.pluralsight.dateTime;

import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.List;

import com.dhruba.pluralsight.dateTime.Person;

public class DateAndTImeJavaEight {
	public static void main(String[] args) {
		
		List<Person> people = StreamUtilForDateTime.readFile("peoplebirthdata.txt");
		
		LocalDate now = LocalDate.of(2014, Month.MARCH, 12);
		people.stream().forEach(
					p -> {
							Period period = Period.between(p.getBirthDate(), now);
							System.out.println(p.getName() + " was born " + period.get(ChronoUnit.YEARS) 
							+ " years and " + period.get(ChronoUnit.MONTHS) + " months ago"); // This is not the number of months ago but the number of months after the year completed
							
							long monthsUntilNow = p.getBirthDate().until(LocalDate.now(),ChronoUnit.MONTHS);
							System.out.println(p.getName() + " was born " + monthsUntilNow + " months ago.");
							
							long daysUntilNow = p.getBirthDate().until(LocalDate.now(),ChronoUnit.DAYS);
							System.out.println(p.getName() + " was born " + daysUntilNow + " days ago.");
							
							System.out.println();
						});
		
	}
}
