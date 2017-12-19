package com.test.inheritance.ex;

public class Main {

	public static void main(String[] args) {
		Buyer b=new Buyer();
		
		Product[] products=new Product[3];
		
		products[0]=new TV();
		products[1]=new Computer(6000000,60000);
		products[2]=new Audio();
		
		b.buy(products[0]);
		b.buy(products[1]);
		b.buy(products[2]);
		b.buy(products[0]);
		b.buy(products[0]);
		b.buy(products[0]);
		
		System.out.println(b);

	}

}
