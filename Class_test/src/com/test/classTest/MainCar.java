package com.test.classTest;

public class MainCar {

	public static void main(String[] args) {

		Car car1 = new Car();
		car1.modelName="�ҳ�Ÿ";
		
		Car car2 = new Car();
		car2.modelName="�׷���";
		
		
		System.out.println("maker : "+car1.maker);
		System.out.println("maker : "+car2.maker);
		
		Car.maker="������";
		
		System.out.println("maker : "+car1.maker);
		System.out.println("�𵨸� : "+car1.modelName);
		System.out.println("maker : "+car2.maker);
		System.out.println("�𵨸� : "+car2.modelName);
		
		car1.maker="����";
		System.out.println("maker : "+car1.maker);
		System.out.println("�𵨸� : "+car1.modelName);
		System.out.println("maker : "+car2.maker);
		System.out.println("�𵨸� : "+car2.modelName);
		
	}

}











