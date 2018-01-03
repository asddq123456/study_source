package ch11;

import java.util.*;

class HashMapEx2 {
	public static void main(String[] args) {
		HashMap<String,Integer> map = new HashMap<String,Integer>();
		map.put("김자바", new Integer(90));
		map.put("김자바", new Integer(100));
		map.put("이자바", new Integer(100));
		map.put("강자바", new Integer(80));
		map.put("안자바", new Integer(90));

		Set<Map.Entry<String, Integer>> set = map.entrySet();
		Iterator<Map.Entry<String, Integer>> it = set.iterator();

		while(it.hasNext()) {
			Map.Entry<String,Integer> e = (Map.Entry<String,Integer>)it.next();
			System.out.println("이름 : "+ e.getKey() + ", 점수 : " + e.getValue());
		}

		Set<String> sset = map.keySet();
		System.out.println("참가자 명단 : " + set);

		Collection<Integer> values = map.values();
		Iterator<Integer> itt = values.iterator();

		int total = 0;

		while(it.hasNext()) {
			Integer i = itt.next();
			total += i.intValue();
		}

		System.out.println("총점 : " + total);
		System.out.println("평균 : " + (float)total/set.size());
		System.out.println("최고점수 : " + Collections.max(values));
		System.out.println("최저점수 : " + Collections.min(values));
	}
}
