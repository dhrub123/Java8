package com.dhruba.java8streams;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamExample extends BaseStream {
	
	public static void main(String[] args) {
		
		List<Product> products = createProductsList();
		
		/**
		 * Filter and collect a list in a different list based on a condition
		 */
		List<Float> filteredProductPriceList = 
				products.stream()
						.filter(p -> p.price > 30000) // filters based on given predicate price > 30000
						//.forEach(p -> System.out.println(p.name)); //iterate stream
						.map(p -> p.price) // fetch price
						.collect(Collectors.toList()); //collect as list
		System.out.println(filteredProductPriceList);
		
		/**
		 * For each ordered - iterate elements in order specified by stream
		 */
		products.stream()
				.forEachOrdered(p -> System.out.println(p.price));
		
		products.stream()
				.map(p ->p.name)
				.forEachOrdered(System.out::println);
		
		/**
		 * Iterate a stream
		 */
		Stream.iterate(1, e->e+1)//initial val = 1, increment by 1
			.filter(e->e%5==0)//only multiple of 5
			.limit(5)//max size = 5
			.forEach(System.out::println);
		
		/**
		 * reduce method
		 */
		Float totalPrice = 
				products.stream()
				.map(p -> p.price)
				.reduce(0.0f, (sum,price)->sum+price);
		System.out.println(totalPrice);
		
		totalPrice = 
				products.stream()
				.map(p -> p.price)
				.reduce(0.0f, Float::sum);
		System.out.println("totalPrice = " + totalPrice);
		
		/**
		 * Summation
		 */
		double totalPrice1 = 
				products.stream()
				.collect(Collectors.summingDouble(p->p.price));
		System.out.println("totalPrice = " + totalPrice1);
		
		double averagePrice = 
				products.stream()
				.collect(Collectors.averagingDouble(p->p.price));
		System.out.println("averagePrice = " + averagePrice);
		
		int sumOfIds = 
				products.stream()
				.collect(Collectors.summingInt(p->p.id));
		System.out.println("sumOfIds = " + sumOfIds);
		
		/**
		 * Finding max and min price
		 */
		float maxPrice = 
				products.stream()
				.map(p -> p.price)
				.max((p1,p2)->p1>p2?1:-1).get();
		System.out.println(maxPrice);
		
		float minPrice = 
				products.stream()
				.map(p -> p.price)
				.min((p1,p2)->p1>p2?1:-1).get();
		System.out.println(minPrice);
		
		/**
		 * Count
		 */
		long count = 
				products.stream().count();
		System.out.println(count);
		
		count = 
				products.stream().collect(Collectors.counting());
		System.out.println(count);
		
		/**
		 * Convert list to set
		 */
		Set<Float> productPriceSet = 
				products.stream()
				.map(p->p.price)
				.collect(Collectors.toSet());
		System.out.println(productPriceSet);
		
		/**
		 * Convert list to map
		 */
		Map<Integer,String> productMap = 
				products.stream()
						.collect(Collectors.toMap(p->p.id, p->p.name));
		System.out.println(productMap);
		
		/**
		 * Method reference in stream
		 */
		filteredProductPriceList = 
				products.stream()
						.filter(p -> p.price > 30000) // filters based on given predicate price > 30000
						//.forEach(p -> System.out.println(p.name)); //iterate stream
						.map(Product::getPrice) // fetch price using method reference getPrice
						.collect(Collectors.toList()); //collect as list
		System.out.println(filteredProductPriceList);
	}
}
