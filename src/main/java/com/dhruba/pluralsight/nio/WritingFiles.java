package com.dhruba.pluralsight.nio;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class WritingFiles {
	
public static void main(String[] args){
		
		Path path = Paths.get("/Users/dhruba/git/Java8/src/main/java/com/dhruba/pluralsight/nio/output.txt");
				
		//using try with resources automatically flushes and closes all resources
		try(BufferedWriter writer = Files.newBufferedWriter(path);
				BufferedWriter writer2 = new BufferedWriter(writer);
				PrintWriter printWriter = new PrintWriter(writer2);
				){
			writer.write("Hello World! ");
			printWriter.printf("\ni = %d\n",12);
			
		}catch(IOException ioe) {
			ioe.printStackTrace();
		}
	}
	
}
