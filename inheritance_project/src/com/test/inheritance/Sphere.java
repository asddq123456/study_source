package com.test.inheritance;

public class Sphere extends Shape{
	
	Point3D center;
	float r;
	
	Sphere(){
		this(new Point3D(0,0,0), 100);
	}
	Sphere(Point3D center, float r){
		this.center=center;
		this.r=r;
	}
	Sphere(float x, float y,float z, float r){
		this.center=new Point3D(x,y,z);
		this.r=r;
	}
}











