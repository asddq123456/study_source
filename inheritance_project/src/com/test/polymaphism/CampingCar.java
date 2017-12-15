package com.test.polymaphism;

public class CampingCar extends Car{
	
	String etc="욕실/침대";
	
	@Override
	public void drive(){
		System.out.println("캠핑카를 운전합니다.");
	}
}
