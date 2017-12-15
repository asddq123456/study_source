package com.test.inheritance;

public class Circle extends Shape{

	Point center;
	float r;
	
	Circle(){
		this(new Point(0,0),100);
	}
	Circle(Point point, float r){
		this.center=point;
		this.r=r;
	}
	Circle(float x, float y, float r){
		this.center=new Point(x,y);
		this.r=r;
	}
}







