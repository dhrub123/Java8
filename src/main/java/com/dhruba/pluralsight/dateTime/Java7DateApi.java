package com.dhruba.pluralsight.dateTime;

import java.util.Calendar;
import java.util.Date;

public class Java7DateApi {
	public static void main(String[] args) {
		
		//create a new Date
		Date date = new Date();
		System.out.println(date);
		
		//create a specificDate
		Calendar calendar = Calendar.getInstance();
		calendar.set(2020,1,20);//Set to 20th February , 2020
		System.out.println(calendar.getTime());
		
		//date one week later
		calendar.add(Calendar.DAY_OF_MONTH, 7);
		Date oneweekLater = calendar.getTime();
		System.out.println(oneweekLater);
		
		//date mutability flaw
		Customer customer = new Customer(new Date());
		System.out.println(customer.getCreationDate());
		customer.getCreationDate().setTime(0L);
		System.out.println(customer.getCreationDate());
	}
}
