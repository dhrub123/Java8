package com.dhruba.java8streams.parallel;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ForkJoinPool;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ParallelStreams {
	
	public static void main(String[] args) {
		
		
		Stream.iterate("+",  s-> s + "+")
			  .limit(6)
			  .forEach(System.out::println);
		
		System.out.println("---------------------------");
		
		//parallel will disrupt order 
		Stream.iterate("+",  s-> s + "+")
		  .parallel()
		  .limit(6)
		  .peek(s->System.out.println(s + "processed in thread " + Thread.currentThread().getName()))
		  .forEach(System.out::println);
		
		System.out.println("---------------------------");
		
		//to handle this , do this
		System.setProperty("java.util.concurrent.ForkJoinPool.common.parallelism", "2");
		//This is not working here, put it at line number 10 to get it working
		Stream.iterate("+",  s-> s + "+")
		  .parallel()
		  .limit(6)
		  .peek(s->System.out.println(s + "processed in thread " + Thread.currentThread().getName()))
		  .forEach(System.out::println);
		System.out.println("getParallelism=" +ForkJoinPool.commonPool().getParallelism());
		
		System.out.println("---------------------------");
		
		List<String> strings = new ArrayList<>();
		
		Stream.iterate("+",  s-> s + "+")
		 // .parallel() --> this will result in exception because of race condition in code,
		//we have to put a concurrent aware array list to make this work
		  .limit(1000) //--> this will determine the number of size on array list
		 // .peek(s->System.out.println(s + "processed in thread " + Thread.currentThread().getName()))
		  .forEach(s -> strings.add(s));
		System.out.println(" # " + strings.size());
		
		System.out.println("---------------------------");
		
		//we have used a concurrent aware array list to make this work but the performance is terrible
		List<String> concurrentAwarestrings = new CopyOnWriteArrayList<>();
		
		Stream.iterate("+",  s-> s + "+")
		  .parallel() 
		  .limit(1000) //--> this will determine the number of size on array list
		  //.peek(s->System.out.println(s + "processed in thread " + Thread.currentThread().getName()))
		  .forEach(s -> concurrentAwarestrings.add(s));
		System.out.println(" # " + concurrentAwarestrings.size());
		
		System.out.println("---------------------------");
		//the right pattern
		List<String> rightStrings = 
			Stream.iterate("+",  s-> s + "+")
			  .parallel() 
			  .limit(1000)
			  .collect(Collectors.toList());
		System.out.println(" # " + rightStrings.size());
		
	}

}
