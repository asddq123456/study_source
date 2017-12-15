package com.test.inheritance;

public class MainShape {

	public static void main(String[] args) {
		//점(25, 26)에 반지름 35인 원.
		
		//Circle circle=new Circle(25,26,35);
		
		//Circle circle=new Circle(new Point(25,26),35);
		
		Point point1=new Point(25,26);
		Circle circle=new Circle(point1,35);
		
		
		
		//점(25,25,35)에 반지름 50인 구.
		
		//Sphere sphere=new Sphere(25,25,35,50);
		
		//Sphere sphere=new Sphere(new Point3d(25,25,35),50);
		
		Point3D point2=new Point3D(25,25,35);
		Sphere sphere=new Sphere(point2,50);

	}

}
