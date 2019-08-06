package com.dhruba.functionalinterface;

public class FunctionalInterfaceExample implements FunctionalSayable{

	public void say(String message) {
		System.out.println(message);
	}
	
	public static void main(String[] args) {
		FunctionalInterfaceExample fie = new FunctionalInterfaceExample();
		fie.say("Say Something");
	}
	
}
