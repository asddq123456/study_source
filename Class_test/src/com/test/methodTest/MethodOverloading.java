package com.test.methodTest;

public class MethodOverloading {

	int sum(int a, int b){
		return a+b;
	}
	
	
	float sum(int a, float b){
		return a+b;
	}
	
	float sum(float b,int a){
		return a+b;
	}
	
	float sum(int a, float b, float c){
		return a+b+c;
	}
	
	float sum(float a, int b , float c){
		return a+b+c;		
	}
	
	float sum(float a, float b, int c){
		return a+b+c;
	}
	
}









