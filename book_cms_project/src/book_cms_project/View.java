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
	
	// ����ȭ��
	boolean mainView(){
		Scanner scan=new Scanner(System.in);
		boolean isExit = false;
		System.out.println("*** ���� ���� ���α׷� ***");
		System.out.println("[1]�α���");
		System.out.println("[2]ȸ������");
		System.out.println("[3]���̵�/�н�����ã��");
		System.out.println("[4]����");
		System.out.print("�޴��� �����ϼ���._");

		String menu = scan.nextLine();
		switch (menu) {
		case "1"://�α���			
				loginView();	
			break;
		case "2": //����			
				joinView();
			break;
		case "3":break;
		case "4":
			System.out.println("\n���α׷��� �����մϴ�.");
			isExit=true;
			break;
		default:break;
		}
		return isExit;
		
	}
	
	// ����ȭ��
	void joinView(){	
		Scanner scan=new Scanner(System.in);
		Member member=new Member();
		System.out.println("\n������ �����ϼ̽��ϴ�.");
		System.out.print("���̵� : ");
		member.setId(scan.nextLine());
		System.out.print("�н����� : ");
		member.setPwd(scan.nextLine());
		int result=service.join(member);
		
		String msg="";
		if(result==-1){ // ���Թ�ó��
			msg="���Կ� �����߽��ϴ�. ��� �� �ٽ� �̿����ּ���.";
		}else{// ����ó��
			msg="���Կ� �����߽��ϴ�.";
		}
		System.out.println(msg+"\n");
		
	}
	
	// �α���ȭ��
	void loginView(){
		Scanner scan=new Scanner(System.in);
		String id="";
		String pwd="";
		System.out.println("\n�α����� �����ϼ̽��ϴ�.");
		System.out.print("���̵� : ");
		id=scan.nextLine();
		System.out.print("�н����� : ");
		pwd=scan.nextLine();
		int result=service.login(id, pwd);
		
		String msg="";
		if(result==-1){ // ���̵� ������
			msg="���̵� �������� �ʽ��ϴ�.";
		}else if(result==0){// �н����� ����ġ
			msg="�н����尡 ����ġ �մϴ�.";
		}else{// �α��� Ȯ��
			msg="�α��ο� �����ϼ̽��ϴ�.";
		}
		System.out.println(msg+"\n");
	}
}











