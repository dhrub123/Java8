package com.dhruba.functionalinterface;

@FunctionalInterface
public interface FunctionalSayable extends Doable{
	//only one abstract method
	void say(String message);
	
	//Class level methods
	int hashCode();
	String toString();
	boolean equals(Object obj);
	
	//default methods
	default void doItNow() {
		System.out.println("Do It Now");
	}

}
