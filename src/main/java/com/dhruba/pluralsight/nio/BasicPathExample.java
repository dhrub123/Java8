package com.dhruba.pluralsight.nio;

import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class BasicPathExample {
	
	public static void main(String[] args) {
		
		Path path1 = Paths.get("/Users/dhruba/Desktop/docs");
		Path path2 = Paths.get("/","Users","dhruba","Desktop","docs");
		
		URI uri = URI.create("file:///Users/dhruba/Desktop/docs");
		Path path3 = Paths.get(uri);
		
		//introduced in java 11
		//Path path4 = Path.of("/Users/dhruba/Desktop/docs");
		System.out.println(Files.exists(path1) + " " + Files.exists(path2) + " "+ Files.exists(path3));
	}
}
