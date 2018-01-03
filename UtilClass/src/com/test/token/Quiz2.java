package com.test.token;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Quiz2 {
	public static void main(String[] args) throws Exception{
		
		Scanner scan=new Scanner(System.in);
		
		String snoStr=scan.nextLine();
		
		StringTokenizer token=new StringTokenizer(snoStr,"-");
		
		String sno1=token.nextToken();
		String sno2=token.nextToken();
		
		String dateStr="19"+sno1;
		
		SimpleDateFormat format=new SimpleDateFormat("yyyyMMdd");
		
		Date date=format.parse(dateStr);
		
		Calendar cal=Calendar.getInstance();
		cal.setTime(date);
		
		String gender
		=(Integer.parseInt(sno2.charAt(0)+"")%2>0)?"����":"����";
		
		String msg="����� ��������� "+
					cal.get(Calendar.YEAR)+
					"�� "+(cal.get(Calendar.MONTH)+1)+"�� "+
					cal.get(Calendar.DATE)+"�� �̸�,"+
					gender+"�Դϴ�.";
		
		System.out.println(msg);
	}
}








