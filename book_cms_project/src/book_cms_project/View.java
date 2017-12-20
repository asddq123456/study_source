package book_cms_project;

import java.util.Scanner;

public class View {
	
	private static View instance=new View();
	private View(){}
	public static View getInstance(){
		return instance;
	}
	
	private Service service;
	public void setService(Service service){
		this.service=service;
	}
	
	// 메인화면
	boolean mainView(){
		Scanner scan=new Scanner(System.in);
		boolean isExit = false;
		System.out.println("*** 도서 관리 프로그램 ***");
		System.out.println("[1]로그인");
		System.out.println("[2]회원가입");
		System.out.println("[3]아이디/패스워드찾기");
		System.out.println("[4]종료");
		System.out.print("메뉴를 선택하세요._");

		String menu = scan.nextLine();
		switch (menu) {
		case "1"://로그인			
				loginView();	
			break;
		case "2": //가입			
				joinView();
			break;
		case "3":break;
		case "4":
			System.out.println("\n프로그램을 종료합니다.");
			isExit=true;
			break;
		default:break;
		}
		return isExit;
		
	}
	
	// 가입화면
	void joinView(){	
		Scanner scan=new Scanner(System.in);
		Member member=new Member();
		System.out.println("\n가입을 선택하셨습니다.");
		System.out.print("아이디 : ");
		member.setId(scan.nextLine());
		System.out.print("패스워드 : ");
		member.setPwd(scan.nextLine());
		int result=service.join(member);
		
		String msg="";
		if(result==-1){ // 가입미처리
			msg="가입에 실패했습니다. 잠시 후 다시 이용해주세요.";
		}else{// 가입처리
			msg="가입에 성공했습니다.";
		}
		System.out.println(msg+"\n");
		
	}
	
	// 로그인화면
	void loginView(){
		Scanner scan=new Scanner(System.in);
		String id="";
		String pwd="";
		System.out.println("\n로그인을 선택하셨습니다.");
		System.out.print("아이디 : ");
		id=scan.nextLine();
		System.out.print("패스워드 : ");
		pwd=scan.nextLine();
		int result=service.login(id, pwd);
		
		String msg="";
		if(result==-1){ // 아이디 비존재
			msg="아이디가 존재하지 않습니다.";
		}else if(result==0){// 패스워드 불일치
			msg="패스워드가 불일치 합니다.";
		}else{// 로그인 확인
			msg="로그인에 성공하셨습니다.";
		}
		System.out.println(msg+"\n");
	}
}











