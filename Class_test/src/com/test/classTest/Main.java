package com.test.classTest;

public class Main {

	public static void main(String[] args) {

		TV tv1 = new TV();

		tv1.powerOnOff();

		tv1.channelUp();

		tv1.volumUp();

		tv1.channel = 45;

		System.out.println(tv1.power);
		System.out.println(tv1.channel);
		System.out.println(tv1.volum);

		TV tv2 = new TV();

		tv2 = tv1;
		
		tv2.volum=100;
		
		System.out.println(tv1.volum);

	}

}







