package com.test.classTest;

public class Car {
	
	static String maker="Daewoo";
	String color;
	int door;
	int gear;
	String modelName;
	int price;
	
	public int getSalePrice(){
		int salePrice=(int)(price/0.9);
		return salePrice;
	}
}
