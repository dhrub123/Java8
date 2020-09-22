package com.dhruba.pluralsight.nio;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.function.Function;
import java.util.stream.Stream;

import com.dhruba.pluralsight.nio.model.Person;

public class CsvFileAnalysis {
	
	public static void main(String[] args) {
		

		Path path = Paths.get("/Users/dhruba/git/Java8/src/main/java/com/dhruba/pluralsight/nio/data.csv");
		
		Function<String, Person> lineToPersonFunction = line -> lineToPerson(line);
		
		boolean exists = Files.exists(path);
		System.out.println("Exists = " + exists);
		
		try(BufferedReader reader = Files.newBufferedReader(path);
			Stream<String> lines = Files.lines(path);	
			Stream<String> lines1 = Files.lines(path);	
				Stream<String> lines1withErrorHandling = Files.lines(path);
				){
			

			//Approach 1 with error handling
			lines1withErrorHandling.filter(line -> !line.startsWith("#"))
										.flatMap(CsvFileAnalysis::lineToPersonStream)
										.forEach(System.out::println);
			
			//Approach 1
			lines1.filter(line -> !line.startsWith("#"))
										.map(CsvFileAnalysis::lineToPerson)
										.forEach(System.out::println);
			
			//Approach 2
			lines.filter(line -> !line.startsWith("#"))
										.map(lineToPersonFunction)
										.forEach(System.out::println);
			
			//Approach 3
			Stream<String> lines2 = reader.lines();
			lines2.filter(line -> !line.startsWith("#"))
										.map(lineToPersonFunction)
										.forEach(System.out::println);
			//Approach 3 - old
			String line = reader.readLine();
			while(line != null) {
				if(!line.startsWith("#")) {
					Person person = lineToPersonFunction.apply(line);
					System.out.println(person);
				}
				line = reader.readLine();
			}
			
		}catch(IOException ioe) {
			ioe.printStackTrace();
		}
	}
	
	private static Person lineToPerson(String line) {

		String elements[] = line.split(";");
		String name = elements[0];
		int age = Integer.parseInt(elements[1]);
		String city = elements[2];

		Person person = new Person(name, age, city);
		return person;

	}
	
	//This will ignore error records and carry on with next record
	private static Stream<Person> lineToPersonStream(String line) {
		
		try{
			String elements[] = line.split(";");
			String name = elements[0];
			int age = Integer.parseInt(elements[1]);
			String city = elements[2];
			
			Person person = new Person(name, age, city);
			return Stream.of(person);
		}catch(Exception e) {
			
		}
		return Stream.empty();
		
	}
	
	
}
