package ch11;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class TreeSetTest {

	public static void main(String[] args) {
		
		Set set=new TreeSet(new Descendering());
		
		set.add(4);
		set.add(1);
		set.add(9);
		set.add(6);
		set.add(10);
		set.add(7);
		
		
		System.out.println(set);
		
		Set memberSet = new TreeSet();
		
		Member mem1=new Member();
		mem1.id="aaa";
		Member mem2=new Member();
		mem2.id="bbb";
		Member mem3=new Member();
		mem3.id="z";
		Member mem4=new Member();
		mem4.id="afcdb";
		Member mem5=new Member();
		mem5.id="bkdbflb";
		
		
		memberSet.add(mem2);
		memberSet.add(mem1);
		memberSet.add(mem3);
		memberSet.add(mem4);
		memberSet.add(mem5);
		
		System.out.println(memberSet);
		

	}

}

class Descendering implements Comparator{

	@Override
	public int compare(Object o1, Object o2) {
		if(o1 instanceof Comparable && o2 instanceof Comparable){
			Comparable c1=(Comparable)o1;
			Comparable c2=(Comparable)o2;
			
			return c2.compareTo(c1);
		}
		return -1;
	}
	
} 








