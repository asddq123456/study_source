package com.test.classTest;

public class InitTest {
	
	static int k;
	static int j;
	static String id="Guest";
	int point;
	
	InitTest(){}
	InitTest(int point){
		this.point=point;
	}
	
	
	public static void main(String[] args) {
		InitTest man=new InitTest(50000);
		
		System.out.println(man.point);
		
		InitTest man2=new InitTest();
	}

}









