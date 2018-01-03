package ex06_22;

public class Exercise6_22 {
	
	public static boolean isNumber(String str){
		boolean result=false;
		try{
			Float.parseFloat(str);
			result=true;
		}catch(Exception e){
			result=false;
		}
		
		return result;		
	}
	
	
	public static void main(String[] args) {
		String str = "123";
		System.out.println(str + "는 숫자입니까 ? " + isNumber(str));
		str = "1234o";
		System.out.println(str + " 는 숫자입니까 ? " + isNumber(str));
	}
}







