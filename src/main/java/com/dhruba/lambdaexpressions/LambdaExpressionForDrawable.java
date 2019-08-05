package com.dhruba.lambdaexpressions;

public class LambdaExpressionForDrawable {
	public static void main(String[] args) {
		int width = 10;
		/*
		 * This is also an example of a lambda expression
		 * with no arguments
		 */
		Drawable drawable = () -> {
			System.out.println("Drawing " + width);
		};
		drawable.draw();
	}
}
