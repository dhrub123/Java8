package com.dhruba.pluralsight.dateTime;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Set;

public class ZonedDateAndTimeAndFormatters {
	public static void main(String[] args) {
		
		Set<String> timeZones = ZoneId.getAvailableZoneIds();
		timeZones.stream().forEach(System.out::println);
		
		ZonedDateTime currentTime = ZonedDateTime.of(1564, 3, 23, //Year, Month, Day
													 14, 24, 53, 0, //h, min, second, nano
													 ZoneId.of("Europe/London") //Time Zone
													 );
		System.out.println(currentTime);
		
		ZonedDateTime currentMeeting = ZonedDateTime.of(LocalDate.of(2020, 4, 23),
														LocalTime.of(9,30),
														ZoneId.of("Europe/London"));
		System.out.println(currentMeeting);
		
		ZonedDateTime nextMeeting = currentMeeting.plus(Period.ofMonths(1));
		System.out.println(nextMeeting);
		ZonedDateTime nextMeetingUS = nextMeeting.withZoneSameInstant(ZoneId.of("US/Central"));
		System.out.println(nextMeetingUS);
		
		//DateFormatters
		System.out.println(DateTimeFormatter.ISO_DATE_TIME.format(nextMeetingUS));
		System.out.println(DateTimeFormatter.RFC_1123_DATE_TIME.format(nextMeetingUS));
	}
}
