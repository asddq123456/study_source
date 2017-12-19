package com.test.inheritance.ex;

public class Computer extends Product implements Soundable,Printable{
	
	public Computer(){
		super(500000,150);
	}
	
	public Computer(int price, int bonusPoint){
		super(price,bonusPoint);
	}

	@Override
	public void sound() {
		System.out.println("Computer Sound");		
	}

	@Override
	public void print() {
		System.out.println("내용을 출력합니다.");		
	}
}







