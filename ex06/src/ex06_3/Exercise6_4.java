package ex06_3;

public class Exercise6_4 {
	public static void main(String args[]) {
		Student s = new Student("ȫ�浿",1,1,100,60,76);
		/*s.setName("ȫ�浿");
		s.setBan(1);
		s.setNo(1);
		s.setKor(100);
		s.setEng(60);
		s.setMath(76);*/
		System.out.println("�̸� :"+s.getName());
		System.out.println("���� :"+s.getTotal());
		System.out.println("��� :"+s.getAverage()); 
		
		System.out.println(s);
		System.out.println(s.info());
	}
}








