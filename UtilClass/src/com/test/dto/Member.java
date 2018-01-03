package com.test.dto;

import java.util.Date;

public class Member {
	private String number;
	private String name;
	private Date birth;
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getBirth() {
		return birth;
	}
	public void setBirth(Date birth) {
		this.birth = birth;
	}
	@Override
	public boolean equals(Object obj) {
		boolean result=false;
		if(obj instanceof Member){
			Member member=(Member)obj;
			result=this.number.equals(member.getNumber());			
		}
		return result;
	}
	@Override
	public String toString() {
		return "Member [number=" + number + ", name=" + name + ", birth=" + birth + "]";
	}
	
	
}







