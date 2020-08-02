package com.dhruba.pluralsight.dateTime;

import java.util.Date;

public class Customer {
	
	private Date creationDate;

	//To overcome Date mutability flaw
	/*public Date getCreationDate() {
		return creationDate;
	}*/
	public Date getCreationDate() {
		return new Date(this.creationDate.getTime());
	}

	public Customer(Date creationDate) {
		this.creationDate = creationDate;
	}
	
}
