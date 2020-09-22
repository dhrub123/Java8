package com.dhruba.pluralsight.nio;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ReadingText {
	
	public static void main(String[] args){
		
		Path path = Paths.get("/Users/dhruba/git/Java8/src/main/java/com/dhruba/pluralsight/nio/sonnet-UTF8.txt");
		boolean exists = Files.exists(path);
		System.out.println("Exists = " + exists);
		
		//using try with resources automatically closes all resources
		try(BufferedReader reader = 
				Files.newBufferedReader(path);
				//if we have specials characters
				//Files.newBufferedReader(path,StandardCharsets.ISO_8859_1);
				){
			String line = reader.readLine();
			while(line != null) {
				System.out.println(line);
				line = reader.readLine();
			}
		}catch(IOException ioe) {
			ioe.printStackTrace();
		}
	}
}
