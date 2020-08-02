package com.dhruba.pluralsight.dateTime;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;

public class DateAdjusterExample {
	public static void main(String[] args) {
		
		LocalDate now = LocalDate.now();
		
		//print next sunday
		LocalDate nextSunday = now.with(TemporalAdjusters.next(DayOfWeek.SUNDAY));
		System.out.println(nextSunday);
		
		//print last tuesday of month
		LocalDate lastTuesdayOfMonth = now.with(TemporalAdjusters.lastInMonth(DayOfWeek.TUESDAY));
		System.out.println(lastTuesdayOfMonth);
	}
}
