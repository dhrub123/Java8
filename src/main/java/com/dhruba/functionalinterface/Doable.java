package com.dhruba.functionalinterface;

public interface Doable {
	
	//default methods
	default void doIt() {
		System.out.println("Do It Now");
	}
		
}
