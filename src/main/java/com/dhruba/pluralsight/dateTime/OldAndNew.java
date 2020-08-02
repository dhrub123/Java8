package com.dhruba.pluralsight.dateTime;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.Date;

public class OldAndNew {
	public static void main(String[] args) {
		
		Date date = new Date();
		
		//instant from date
		Instant instant = date.toInstant();
		System.out.println(instant);
		
		//date from instant
		date = Date.from(instant);
		System.out.println(date);
		
		//timestamp from instant
		Timestamp timestamp = Timestamp.from(instant);
		System.out.println(timestamp);
		
		//instant from timestamp
		instant = timestamp.toInstant();
		System.out.println(instant);
		
	}
}
