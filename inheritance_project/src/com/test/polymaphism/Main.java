package com.test.polymaphism;

public class Main {
	
	public static void main(String[] args){
		
		FireEngine fCar=new FireEngine();
		
		fCar.drive();
		
		Car car=fCar;
		
		car.drive();
		
		car=new Ambulance();
		
		car.drive();
			
		//fcar=car;
		
		String etc=((Ambulance)car).etc;
		
		System.out.println(etc);
		
		car=fCar;
		
		Car car1=new FireEngine();
		Car car2=new Ambulance();
		Car car3=new CampingCar();
		Car car4=new Car();
		
		System.out.println("car1 : "+carNo(car1));
		System.out.println("car2 : "+carNo(car2));
		System.out.println("car3 : "+carNo(car3));
		System.out.println("car4 : "+carNo(car4));
		
		
	}
	
	
	static String carNo(Car car){
		String carNo=null;
		if(car instanceof FireEngine){
			carNo=((FireEngine)car).no;
		}else{
			carNo="차 번호가 없습니다.";
		}
		return carNo;
	}
}






