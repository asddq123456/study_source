package com.test.main;

public class MainString {

	public static void main(String[] args) {
		String str1="123";
		String str2=new String("123");
		String str3=new String("123");
		
		System.out.println(str1==str2);
		System.out.println(str3==str2);
		
		System.out.println(str1.equals(str2));
		System.out.println(str3.equals(str2));
		
		int i=1;
		Integer ii=1;
		Integer iii=new Integer(1)+3;

	}

}







