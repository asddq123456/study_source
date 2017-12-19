package com.test.polymaphism;

public class Child extends Parent{
	
	int x=200;
	
	void method(){
		System.out.println("Child Method");
	}
	
	void method2(){
		System.out.println("This only Child Method");
	}

	@Override
	public String toString() {
		return "Child [x=" + x + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}
	
	

}
