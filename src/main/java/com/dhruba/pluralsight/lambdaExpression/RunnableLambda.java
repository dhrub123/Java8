package com.dhruba.pluralsight.lambdaExpression;

public class RunnableLambda {
	
	public static void main(String[] args) throws InterruptedException {
		
		Thread thread = null;
		
		//Threading using anonymous class
		Runnable runnable = new Runnable() {
			@Override
			public void run() {
				for(int i=0; i<3; i++) {
					System.out.println("Current thread = " + Thread.currentThread().getName());
				}
			}
		};
		thread = new Thread(runnable);
		thread.start();
		thread.join();
		
		//Threading using lambda
		/*
		 * () this is because run() does not have arguments and the expression after lambda is the
		 * method body of run
		 */
		Runnable runnableLambda = () -> {
			for(int i=0; i<3; i++) {
				System.out.println("Current lambda thread = " + Thread.currentThread().getName());
			}
		};
		thread = new Thread(runnableLambda);
		thread.start();
		thread.join();
	}

}
