package com.test.inheritance.ex;

public class Audio extends Product implements Soundable{

	public Audio(){
		super(30000,30);
	}
	
	public Audio(int price, int bonusPoint){
		super(price, bonusPoint);
	}

	@Override
	public void sound() {
		
		System.out.println("Audio sound");
		
	}
}






