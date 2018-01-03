package com.test.test;

import java.util.Scanner;

public class IsHangleOK {

	public static void main(String[] args) {
		
		Scanner scan=new Scanner(System.in);
		
		System.out.println("컵 사이즈를 입력하시오.");
		int size=Integer.parseInt(scan.nextLine());
		
		if(size < 100){
			System.out.println("small");
		}else if(size <200){
			System.out.println("medium");
		}else{
			System.out.println("large");
		}
		

	}

}




