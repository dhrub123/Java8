package com.dhruba.pluralsight.nio;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class WalkPattern {
	
	public static void main(String[] args) throws IOException {
		
		Path path = Paths.get("/Users/dhruba/git/Java8/src/main/java/com/dhruba");
		System.out.println("Is Directory ? = " + Files.isDirectory(path));
		
		Stream<Path> stream = Files.walk(path);
		long count = stream.count();
		System.out.println("Total Count = " + count);
		
		long directoryCount = Files.walk(path)
				.filter(p -> Files.isDirectory(p))//Files::isDirectory can also be used
				.count();
		
		long fileCount = Files.walk(path)
				.filter(p -> Files.isRegularFile(p))//Files::isRegularFile can also be used
				.count();
		
		System.out.println("Count of Directories = " + directoryCount
				+ " Count of Files = " + fileCount);
	}
}
