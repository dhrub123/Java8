package com.dhruba.functionalinterface;

public interface Doable {
	
	//default methods
	default void doIt() {
		System.out.println("Do It Now");
	}
	
	//static method
	static void doMore() {
		System.out.println("Do More");
	}
		
}
