package com.dhruba.pluralsight.dateTime;

import java.time.Duration;
import java.time.Instant;

public class InstantAndDuration {
	
	public static void main(String[] args) {
		
		//Instant and Duration
		Instant instant = Instant.MIN;
		System.out.println(instant);
		
		instant = Instant.MAX;
		System.out.println(instant);
		
		Instant start = Instant.now();
		System.out.println(start);
		
		Instant end = Instant.now();
		System.out.println(end);
		
		Duration elapsed = Duration.between(start, end);
		System.out.println(elapsed.toMillis());
		
		
	}

}
