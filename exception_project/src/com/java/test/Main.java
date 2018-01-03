package com.java.test;

import java.util.Scanner;

public class Main {
	static int num;

	public static void main(String[] args) {
		
		try {
			call();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	static void call()throws Exception{

		Scanner scan = new Scanner(System.in);
		
		
		try{		
			num=scan.nextInt();
			System.out.println(1/num);
		}catch(Exception e){			
			System.out.println(num+"은 입력하지 마요...바보...");
			throw e;
		}
	}

}





