package com.dhruba.lambdaexpressions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LambdaExpressionComparator {
	public static void main(String[] args) {

		List<Product> productList = new ArrayList<Product>();
		productList.add(new Product(1, "HP", 35));
		productList.add(new Product(2, "Dell", 40));
		productList.add(new Product(3, "Acer", 30));
		
		Collections.sort(productList, (p1,p2) ->{
			return p1.name.compareTo(p2.name);
			}
		);
		
		productList.forEach((p) ->{
			System.out.println(p.id + " " +  p.name + " " + p.price);
		});

	}
}
