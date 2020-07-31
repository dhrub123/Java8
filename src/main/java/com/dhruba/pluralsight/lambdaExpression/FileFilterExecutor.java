package com.dhruba.pluralsight.lambdaExpression;

import java.io.File;
import java.io.FileFilter;

public class FileFilterExecutor {
	
	public static void main(String[] args) {
		
		File dir = new File("/Users/dhruba/Desktop/Study for Interview");
		File[] files = null;
		
		//Interface Implementation
		JavaFileFilter fileFilter = new JavaFileFilter();
		files = dir.listFiles(fileFilter);
		System.out.println(files.length);
		
		//Anonymous class Implementation
		FileFilter anonFilter = new FileFilter() {
			public boolean accept(File file) {
				return file.getName().endsWith("xlsx");
			}
		};
		files = dir.listFiles(anonFilter);
		System.out.println(files.length);
		
		//Lambda Filter
		FileFilter lambdaFilter = (File file) -> file.getName().endsWith("xlsx");
		files = dir.listFiles(lambdaFilter);
		System.out.println(files.length);
	}
}
