package com.test.polymaphism;

public class Main2 {

	public static void main(String[] args) {
		
		Parent p = new Parent();
		
		System.out.println(p.x);
		p.method();
		
		
		p= new Child();
		
		System.out.println(p.x);
		p.method();
		
		Child c=(Child)p;
		System.out.println(c);
		System.out.println(c.x);
		c.method2();
		
		
		

	}

}
