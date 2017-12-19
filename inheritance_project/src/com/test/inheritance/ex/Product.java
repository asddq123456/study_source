package com.test.inheritance.ex;

public class Product {
	private int price;
	private int bonusPoint;
	
	public Product(){
		this(0,0);
	}
	
	public Product(int price, int bonusPoint) {
		super();
		this.price = price;
		this.bonusPoint = bonusPoint;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getBonusPoint() {
		return bonusPoint;
	}

	public void setBonusPoint(int bonusPoint) {
		this.bonusPoint = bonusPoint;
	}

	@Override
	public String toString() {
		return "Product [price=" + price + ", bonusPoint=" + bonusPoint + "]";
	}
	
	
	
}
