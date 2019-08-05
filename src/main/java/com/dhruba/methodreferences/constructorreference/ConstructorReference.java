package com.dhruba.methodreferences.constructorreference;

public class ConstructorReference {
	public static void main(String[] args) {
		Messageable messageable = Message::new;
		messageable.getMessage("Hello");
	}
}
