package ex06_3;

public class Exercise6_4 {
	public static void main(String args[]) {
		Student s = new Student("È«±æµ¿",1,1,100,60,76);
		/*s.setName("È«±æµ¿");
		s.setBan(1);
		s.setNo(1);
		s.setKor(100);
		s.setEng(60);
		s.setMath(76);*/
		System.out.println("ÀÌ¸§ :"+s.getName());
		System.out.println("ÃÑÁ¡ :"+s.getTotal());
		System.out.println("Æò±Õ :"+s.getAverage()); 
		
		System.out.println(s);
		System.out.println(s.info());
	}
}








