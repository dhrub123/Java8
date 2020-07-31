package com.dhruba.pluralsight.lambdaExpression;

import java.io.File;
import java.io.FileFilter;

public class JavaFileFilter implements FileFilter{

	public boolean accept(File file) {
		return file.getName().endsWith("xlsx");
	}
	
	
}
