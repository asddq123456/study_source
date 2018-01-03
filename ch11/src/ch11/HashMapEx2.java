package ch11;

import java.util.*;

class HashMapEx2 {
	public static void main(String[] args) {
		HashMap<String,Integer> map = new HashMap<String,Integer>();
		map.put("���ڹ�", new Integer(90));
		map.put("���ڹ�", new Integer(100));
		map.put("���ڹ�", new Integer(100));
		map.put("���ڹ�", new Integer(80));
		map.put("���ڹ�", new Integer(90));

		Set<Map.Entry<String, Integer>> set = map.entrySet();
		Iterator<Map.Entry<String, Integer>> it = set.iterator();

		while(it.hasNext()) {
			Map.Entry<String,Integer> e = (Map.Entry<String,Integer>)it.next();
			System.out.println("�̸� : "+ e.getKey() + ", ���� : " + e.getValue());
		}

		Set<String> sset = map.keySet();
		System.out.println("������ ��� : " + set);

		Collection<Integer> values = map.values();
		Iterator<Integer> itt = values.iterator();

		int total = 0;

		while(it.hasNext()) {
			Integer i = itt.next();
			total += i.intValue();
		}

		System.out.println("���� : " + total);
		System.out.println("��� : " + (float)total/set.size());
		System.out.println("�ְ����� : " + Collections.max(values));
		System.out.println("�������� : " + Collections.min(values));
	}
}
