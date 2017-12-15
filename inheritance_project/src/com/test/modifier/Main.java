package com.test.modifier;

public class Main {
	
	public static void main(String[] args){
		Cap cap=new Cap();
		cap.setX(100);
		cap.setY(200);
		cap.setZ(300);
		
		System.out.println(cap.getX());
		System.out.println(cap.getY());
		System.out.println(cap.getZ());
	}
}
