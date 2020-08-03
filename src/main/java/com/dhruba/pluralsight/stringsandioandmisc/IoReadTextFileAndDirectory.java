package com.dhruba.pluralsight.stringsandioandmisc;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class IoReadTextFileAndDirectory {
	
	public static void main(String[] args) {
		
		//Read Text File
		//Using Buffered Reader
		try(
			BufferedReader reader = new BufferedReader(
										new FileReader(
												new File("/Users/dhruba/git/Java8/src/main/java/com/dhruba/pluralsight/stringsandioandmisc/people.txt")));
		){
			Stream<String> stream = reader.lines();//This is new In Java 8
			stream.filter(line -> line.contains("Penelope"))
				  .findFirst()
				  .ifPresent(System.out::println);
			
		}catch(IOException iex) {
			
		}
		
		//Using Path
		Path path = Paths.get("/Users/dhruba/git/Java8/src/main/java/com/dhruba/pluralsight/stringsandioandmisc/people.txt");
		try(
			Stream<String> stream = Files.lines(path);//This is new In Java 8
			
		){
			stream.filter(line -> line.contains("Albert"))
				  .findFirst()
				  .ifPresent(System.out::println);
			
		}catch(IOException iex) {
			
		}
		
		//Read Directory - only 1st level
		path = Paths.get("/Users/dhruba/Desktop/docs");
		try(
			Stream<Path> stream = Files.list(path);//This returns a stream of Path
			
		){
			stream.filter(p -> p.toFile().isDirectory())
				  .forEach(System.out::println);
			
		}catch(IOException iex) {
			
		}
		
		//Read Directory all levels
		try(
			Stream<Path> stream = Files.walk(path);//This returns a stream of Path
			
		){
			stream.filter(p -> p.toFile().isDirectory())
				  .forEach(System.out::println);
			
		}catch(IOException iex) {
			
		}
		System.out.println("----------");
		//Read Directory 2 levels Files.walk(path,2)
		try(
			Stream<Path> stream = Files.walk(path,2);//This returns a stream of Path
			
		){
			stream.filter(p -> p.toFile().isDirectory())
				  .forEach(System.out::println);
			
		}catch(IOException iex) {
			
		}
		
	}

}
