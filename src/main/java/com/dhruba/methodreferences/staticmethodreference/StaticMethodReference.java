package com.dhruba.methodreferences.staticmethodreference;

import com.dhruba.methodreferences.instancemethodreferences.StaticSayable;

public class StaticMethodReference {
	public static void saySomething() {
		System.out.println("This is a static method");
	}
	
	public static void main(String[] args) {
		StaticSayable sayable = StaticMethodReference :: saySomething;
		sayable.say();
	}
}
