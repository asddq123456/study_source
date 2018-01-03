package com.test.classTest;

public class TV {
	
	// 속성 : 전원, 채널, 볼륨
	boolean power=false;
	int channel=0;
	int volum=0;
	
	//기능 : 전원켜기, 채널변경, 볼륨변경
	public void powerOnOff(){
		power=!power;
	}
	
	public void channelUp(){
		channel++;
	}
	
	public void channelDown(){
		channel--;
	}
	
	public void volumUp(){
		volum++;
	}
	
	public void volumDown(){
		volum--;
	}
}




