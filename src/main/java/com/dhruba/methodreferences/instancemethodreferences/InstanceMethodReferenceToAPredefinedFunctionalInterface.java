package com.dhruba.methodreferences.instancemethodreferences;

import java.util.function.BiFunction;

public class InstanceMethodReferenceToAPredefinedFunctionalInterface {
	public void threadStatus() {
		System.out.println("Thread running");
	}
	
	public static void main(String[] args) {
		
		Thread thread = new Thread(
				new InstanceMethodReferenceToAPredefinedFunctionalInterface()::threadStatus
				);
		thread.start();
		
		//We are using Bifunction interface and using its apply method
		BiFunction<Integer, Integer, Integer>adder = new Arithmetic()::add;
		System.out.println(adder.apply(10, 20));
		
		//We can also use overloading
		BiFunction<Integer, Float, Float>adder2 = new Arithmetic()::add;
		System.out.println(adder2.apply(10, 20.0f));
		
		BiFunction<Float, Float, Float>adder3 = new Arithmetic()::add;
		System.out.println(adder3.apply(10.0f, 20.0f));
	}
}
