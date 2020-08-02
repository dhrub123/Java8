package com.dhruba.pluralsight.dateTime;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.time.Period;
import java.time.temporal.ChronoUnit;

public class LocalDateAndTime {
	
	public static void main(String[] args) {
		
		LocalDate now = LocalDate.now();
		System.out.println(now);
		
		LocalDate date = LocalDate.of(1954, Month.APRIL, 23);
		System.out.println(date);
		
		Period period = date.until(LocalDate.now());
		System.out.println("# years = " + period.getYears());
		
		long days = date.until(now,ChronoUnit.DAYS);
		System.out.println("# days = " + days);
		
		//LocalTime
		LocalTime localTimeNow = LocalTime.now();
		System.out.println(localTimeNow);
		LocalTime tenTwenty = LocalTime.of(10,20);
		System.out.println(tenTwenty);
		
		LocalTime bedTime = LocalTime.of(23,0);
		System.out.println(bedTime);
		LocalTime wakeupTime = bedTime.plusHours(8);
		System.out.println(wakeupTime);
	}

}
