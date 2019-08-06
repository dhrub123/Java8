package com.dhruba.functionalinterface;

public class FunctionalInterfaceExample implements FunctionalSayable{

	public void say(String message) {
		System.out.println(message);
	}
	
	public static void main(String[] args) {
		FunctionalInterfaceExample fie = new FunctionalInterfaceExample();
		fie.say("Say Something");
		fie.doIt();//Calling default method of interface
		Doable.doMore();//Calling static method of interface
		/**
		 * Use a functional interface in lambda
		 */
		FunctionalSayable fs = (name) -> {
			System.out.println("hello" + name);
		};
		fs.say(" Dhruba");
	}
	
}
