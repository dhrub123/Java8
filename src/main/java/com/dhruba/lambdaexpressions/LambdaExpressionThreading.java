package com.dhruba.lambdaexpressions;

public class LambdaExpressionThreading {
	public static void main(String[] args) {

		Runnable r1 = new Runnable() {
			public void run() {
				System.out.println("Thread 1 running");
			}
		};
		Thread t = new Thread(r1);
		t.start();

		/*
		 * Threading with Lambda
		 */
		Runnable r2 = () -> {
			System.out.println("Thread 2 running");
		};
		Thread t2 = new Thread(r2);
		t2.start();

	}
}
