package com.dhruba.java8streams;

import java.util.ArrayList;
import java.util.List;

public class BaseStream {
	
	public static List<Product> createProductsList(){
		
		List<Product> products = new ArrayList<Product>();
		products.add(new Product(1, "Apple", 90000f));
		products.add(new Product(2, "ROG", 80000f));
		products.add(new Product(3, "Triton", 70000f));
		products.add(new Product(4, "Aorus", 65000f));
		products.add(new Product(5, "Dell", 35000f));
		products.add(new Product(6, "HP", 25000f));
		return products;
	}
}
