package com.test.format;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.StringTokenizer;

public class DateFormatEx {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		String dateStr=scan.nextLine();
		
		StringTokenizer token=new StringTokenizer(dateStr,"-",true);		
		
		dateStr="";
				
		for(int count=1;token.hasMoreTokens();count++){
			String tokenStr=token.nextToken();
			if(count==3){
				dateStr+=Integer.parseInt(tokenStr)+1;				
			}else{
				dateStr+=tokenStr;
			}
		}		
		
		SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
		
		Date inputDate=null;
		
		try {
			inputDate = format.parse(dateStr);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		
		SimpleDateFormat outFormat=new SimpleDateFormat("yyyy.MM.dd");
				
		System.out.println(outFormat.format(inputDate));

	}

}







