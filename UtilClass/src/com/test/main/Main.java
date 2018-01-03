package com.test.main;

import com.test.dto.Member;

public class Main {

	public static void main(String[] args) {
		Member mem1=new Member();
		mem1.setNumber("0521245");
		
		Member mem2=new Member();
		mem2.setNumber("2541245");
		
		Member mem3=new Member();
		mem3.setNumber(mem1.getNumber());
		
		
		System.out.println(mem1.equals(mem2));
		System.out.println(mem1.equals(mem3));
		
		System.out.println(mem1==mem2);
		System.out.println(mem1==mem3);
		
		System.out.println(mem1);
	}

}





