package com.test.token;

import java.util.Scanner;
import java.util.StringTokenizer;

public class Quiz1 {

	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		
		String phoneStr=scan.nextLine();
		
		StringTokenizer token=new StringTokenizer(phoneStr,"-");
		
		phoneStr="";
		
		while(token.hasMoreTokens()){
			phoneStr+=token.nextToken();
		}
		
		System.out.println(phoneStr);

	}

}







