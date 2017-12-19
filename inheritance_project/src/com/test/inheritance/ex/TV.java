package com.test.inheritance.ex;

public class TV extends Product implements Soundable{
	
	public TV(){
		super(1500000,500);
	}
	
	public TV(int price, int bonusPoint){
		super(price,bonusPoint);
	}

	@Override
	public void sound() {
		System.out.println("TV Sound");		
	}
}
