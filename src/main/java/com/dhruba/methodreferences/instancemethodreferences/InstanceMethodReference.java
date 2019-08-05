package com.dhruba.methodreferences.instancemethodreferences;

import com.dhruba.methodreferences.instancemethodreferences.StaticSayable;

public class InstanceMethodReference {
	public void saySomething() {
		System.out.println("This is a static method");
	}
	
	public static void main(String[] args) {
		InstanceMethodReference instanceMethodReference = new InstanceMethodReference();
		
		StaticSayable sayable = instanceMethodReference :: saySomething;
		sayable.say();
	}
}
