package com.project.employee;

import java.util.Arrays;
import java.util.Optional;

public class Test {
public static void main(String args[]) {
	String str = "aabbccdde";
	Optional<String> firstChar=Arrays.stream(str.split("")).distinct().findFirst();
	System.out.println(firstChar);
	
	

	String a="hello";
	String b="hello";
	System.out.println(a==b);
			
}
}
