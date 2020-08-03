package com.dhruba.pluralsight.stringsandioandmisc;

public class NumberAndMethodReferences {
	
	public static void main(String[] args) {
		
		long max = Long.max(2l, 3l);
		System.out.println(max);
		
		//hashcode
		//JDK7
		long number = 3823834947239749234L;
		int hashcode = new Long(number).hashCode();
		System.out.println(hashcode);
		//JDK8
		hashcode = Long.hashCode(number);
		System.out.println(hashcode);
	}

}
