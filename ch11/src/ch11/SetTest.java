package ch11;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class SetTest {
	
	public static void main(String[] args){
		
		Set set=new HashSet();
		
		set.add(new Integer(1));
		set.add(new Integer(1));
		set.add(new Integer(1));
		set.add(new Integer(1));
		set.add(new Integer(1));
		
		set.add(2);
		set.add(3);
		set.add(4);
		set.add(5);
		set.add("dldkfkf");
		set.add("dldkfkf");
		set.add(new String("dldkfkf"));
		set.add('a');
		set.add(false);
		set.add(4f);
		
		System.out.println(set);
		
		Iterator it=set.iterator();
		while(it.hasNext()){
			
			String str=it.next().toString();
			System.out.println(str.charAt(0));
			
		}
		
		Member mem1=new Member();
		mem1.id="mimi";
		
		Member mem2=new Member();
		mem2.id="mimi";
		
		set.add(mem1);
		set.add(mem2);
		
		System.out.println(set);
		
		
		
	}
}










