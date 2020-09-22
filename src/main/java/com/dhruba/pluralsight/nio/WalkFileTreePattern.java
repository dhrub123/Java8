package com.dhruba.pluralsight.nio;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitor;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;

public class WalkFileTreePattern {
	
	public static void main(String[] args) throws IOException {
		
		Path path = Paths.get("/Users/dhruba/git/Java8/src/main/java/com/dhruba");
		System.out.println("Is Directory ? = " + Files.isDirectory(path));
		
		FileVisitor<Path> visitor = new FileVisitor<Path>() {
			
			private long countFiles = 0L;
			private long countDirectories = 0L;
			
			@Override
			public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
				//We are going to visit this directory
				countDirectories++;
				System.out.println("Count of Directories" + countDirectories);
				return FileVisitResult.CONTINUE;
			}

			@Override
			public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {

				countFiles++;
				System.out.println("Count of Files" + countFiles);
				return FileVisitResult.CONTINUE;

			}

			@Override
			public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
				//We are going to visit this directory
				return FileVisitResult.CONTINUE;
			}

			@Override
			public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
				//We are going to visit this directory
				return FileVisitResult.CONTINUE;
			}
			
			
			
		};
		
		
		Files.walkFileTree(path, visitor);
	}
}
