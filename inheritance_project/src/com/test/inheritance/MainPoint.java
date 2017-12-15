package com.test.inheritance;

public class MainPoint {
	
	public static void main(String[] args){
		
		Point point=new Point(3,5);
		System.out.println(point.getLocation());
		
		Point3D point3D=new Point3D(3,4,5);
		System.out.println(point3D.getLocation());
	}
}
