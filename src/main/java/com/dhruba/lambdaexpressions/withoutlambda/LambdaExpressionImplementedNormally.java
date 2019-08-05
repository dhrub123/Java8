package com.dhruba.lambdaexpressions.withoutlambda;

import com.dhruba.lambdaexpressions.Drawable;

public class LambdaExpressionImplementedNormally {
	
	public static void main(String[] args) {
		
		//Anonymous class used here
		Drawable drawable = new Drawable() {
			int width = 10;
			public void draw() {
				System.out.println("Drawing " + width);
			}
		};
		drawable.draw();
	}
}
