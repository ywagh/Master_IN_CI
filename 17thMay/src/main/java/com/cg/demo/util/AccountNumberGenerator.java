package com.cg.demo.util;

public class AccountNumberGenerator {

	private static int counter=1;
	
	public static int getNumber(){
		
		return counter++;
	}
}
