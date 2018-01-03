package ch11;

import java.util.HashSet;
import java.util.Set;

public class Lotto {

	public static void main(String[] args) {
		
		Set lottoNum=new HashSet();
		
		while(lottoNum.size()<6){
			int num=(int)(Math.random()*45+1);
			lottoNum.add(num);
		}
		System.out.println(lottoNum);

	}

}






