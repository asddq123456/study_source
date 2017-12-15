package com.test.inheritance;




public class Point {

	float x;
	float y;

	public Point() {
		this(0, 0);
	}

	public Point(float x, float y) {
		this.x = x;
		this.y = y;
	}

	String getLocation() {
		return "x : " + x + ", y : " + y;
	}

}






