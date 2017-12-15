package com.test.polymaphism;

public class Ambulance extends Car{

	String etc="응급처치도구";
	
	@Override
	public void drive(){
		System.out.println("응급차를 운전합니다.");
	}
}
