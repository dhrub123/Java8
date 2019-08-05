package com.dhruba.lambdaexpressions;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class LambdaExpressionFilter {
	public static void main(String[] args) {

		List<Product> productList = new ArrayList<Product>();
		productList.add(new Product(1, "HP", 35));
		productList.add(new Product(2, "Dell", 40));
		productList.add(new Product(3, "Acer", 30));
		productList.add(new Product(4, "Asus", 45));
		productList.add(new Product(5, "Apple", 70));
		productList.add(new Product(6, "Microsoft", 65));
		
		Stream<Product> filteredData = productList.stream().filter(
				p -> p.price > 40
		);
		
		filteredData.forEach((p) ->{
			System.out.println(p.id + " " +  p.name + " " + p.price);
		});

	}
}
