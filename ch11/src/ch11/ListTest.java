package ch11;

import java.util.ArrayList;
import java.util.List;

public class ListTest {

	public static void main(String[] args) {
		
		List list=new ArrayList();
		
		list.add(1); //list.add(new Integer(1));
		list.add(true);
		list.add(1F);
		list.add("dfdfdf");
		list.add('d');
		
		System.out.println(list);
		
		System.out.println(list.get(3));

	}

}








