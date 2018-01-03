package com.test.classTest;

public class MainCar {

	public static void main(String[] args) {

		Car car1 = new Car();
		car1.modelName="¼Ò³ªÅ¸";
		
		Car car2 = new Car();
		car2.modelName="±×·£Àú";
		
		
		System.out.println("maker : "+car1.maker);
		System.out.println("maker : "+car2.maker);
		
		Car.maker="½¦º¸·¹";
		
		System.out.println("maker : "+car1.maker);
		System.out.println("¸ðµ¨¸í : "+car1.modelName);
		System.out.println("maker : "+car2.maker);
		System.out.println("¸ðµ¨¸í : "+car2.modelName);
		
		car1.maker="Çö´ë";
		System.out.println("maker : "+car1.maker);
		System.out.println("¸ðµ¨¸í : "+car1.modelName);
		System.out.println("maker : "+car2.maker);
		System.out.println("¸ðµ¨¸í : "+car2.modelName);
		
	}

}











