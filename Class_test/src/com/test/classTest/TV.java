package com.test.classTest;

public class TV {
	
	// �Ӽ� : ����, ä��, ����
	boolean power=false;
	int channel=0;
	int volum=0;
	
	//��� : �����ѱ�, ä�κ���, ��������
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




