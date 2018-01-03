package ch11;

import java.util.*;

class HashMapEx4 {
	public static void main(String[] args) {
		String[] data = { "A","K","A","K","D","K","A","K","K","K","Z","D" };

		Map<String,Integer> map = new TreeMap<String,Integer>();

		for(int i=0; i < data.length; i++) {
			if(map.containsKey(data[i])) {
				Integer value = (Integer)map.get(data[i]);
				map.put(data[i], value+ 1);
			} else {
				map.put(data[i], 1);			
			}
		}

		Iterator<Map.Entry<String, Integer>> it = map.entrySet().iterator();

		while(it.hasNext()) {
			Map.Entry<String,Integer> entry = (Map.Entry<String,Integer>)it.next();
			int value = ((Integer)entry.getValue()).intValue();
			System.out.println(entry.getKey() + " : " + printBar('#', value) + " " + value );
		}
	} // main

	public static String printBar(char ch, int value) { 
		//char[] bar = new char[value]; 
		String retStr="";
		for(int i=0; i < value; i++) { 
			 retStr+=ch; // retStr=retStr+ch;
		} 

		return retStr; 	// String(char[] chArr)
	}
}




