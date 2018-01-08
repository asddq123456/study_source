package com.spring.view;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import com.jdbc.exception.FailToVerifiedIDException;
import com.jdbc.exception.InvalidPasswordException;
import com.jdbc.exception.NotFoundIDException;
import com.jdbc.exception.NullLoginUserException;
import com.jdbc.scope.SessionScope;
import com.spring.dto.MemberVO;
import com.spring.service.MemberService;

public class ViewImpl implements View {
	
	private static ViewImpl instance=new ViewImpl();
	private ViewImpl(){}
	public static ViewImpl getInstance(){
		return instance;
	}
	
	private MemberService service;

	public void setService(MemberService service) {
		this.service = service;
	}

	@Override
	public void mainView() {
		while (true) {
			System.out.println("********  ȸ�� ���� ���α׷� Ver 1.0  *******");
			System.out.println();
			if (SessionScope.loginUser != null) {
				System.out.println("[1] �α׾ƿ�");
			} else {
				System.out.println("[1] �α���");
			}
			System.out.println("[2] ȸ������Ʈ");
			System.out.println("[3] ȸ�����");
			System.out.println("[4] ����");
			System.out.print("�޴��� �����Ͻÿ�.[1~4] : _");

			Scanner scan = new Scanner(System.in);
			switch (scan.nextLine().trim()) {
			case "1": // �α���
				if (SessionScope.loginUser == null) {
					loginView();
				} else {
					try {
						service.logout();						
						System.out.println("�α׾ƿ� �ϼ̽��ϴ�.");
					} catch (SQLException e) {
						System.out.println("�α׾ƿ��� ������ �߻��߽��ϴ�.\n" + "���α׷��� �����Ͻñ� �ٶ��ϴ�..");
					} catch (NullLoginUserException e) {
						System.out.println("�α����� ����ڰ� �����ϴ�.");
					}
				}
				break;
			case "2": // ȸ������Ʈ
				memberListView();
				break;
			case "3": // ȸ�����
				if (SessionScope.loginUser != null) {
					joinMemberView();
				} else {
					System.out.println("�α����� �ʿ��� �����Դϴ�");
					System.out.println("����Ϸ��� ���͸� ġ����.");
					scan.nextLine();
				}
				break;
			case "4": // ����
				System.out.println("���α׷��� �����մϴ�.");
				return;
			default:
				System.out.println("�Է��� �ùٸ��� �ʽ��ϴ�.");
			}
		}
	}

	@Override
	public void loginView() {
		Scanner scan = new Scanner(System.in);
		LoginRequest req = new LoginRequest();
		System.out.println();
		System.out.println("** �α��� ȭ�� **");
		System.out.println("���̵� �Է��ϼ���.");
		req.setId(scan.nextLine().trim());
		System.out.println("�н����带 �Է��ϼ���.");
		req.setPwd(scan.nextLine().trim());

		try {
			service.login(req);
			System.out.println("�α��ο� �����߽��ϴ�.");
			System.out.println("����Ϸ��� ���͸� ġ����.");
			scan.nextLine();
		} catch (SQLException e) {
			System.out.println("�ý��ۿ����� �߻��߽��ϴ�.\n��� �� �ٽ� �̿�ٶ��ϴ�");
		} catch (NotFoundIDException e) {
			System.out.println("�������� �ʴ� ���̵��Դϴ�.\n�ٽ� �õ��ϼ���.");
		} catch (InvalidPasswordException e) {
			System.out.println("�н����尡 ����ġ�մϴ�..\n�ٽ� �õ��ϼ���.");
		}

	}

	@Override
	public void memberListView() {
		while (true) {
			try {
				List<MemberVO> memberList = service.getMemberList();

				System.out.println("����\t���̵�\t�н�����\t�̸�\t��¥");
				int count = 1;
				for (MemberVO member : memberList) {
					SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
					String date = format.format(member.getMember_regDate());
					System.out.print("[" + (count++) + "]\t");
					System.out.print(member.getMember_id() + "\t");
					System.out.print(member.getMember_pwd() + "\t");
					System.out.print(member.getMember_name() + "\t");
					System.out.print(date + "\n");
				}
				System.out.println("�󼼺��� ����Ʈ ��ȣ�� �Է��ϼ���.(�ʱ�޴� : M)");
				Scanner scan = new Scanner(System.in);
				int memberNum = 0;
				String no = scan.nextLine();
				try {
					memberNum = Integer.parseInt(no);
				} catch (Exception e) {
					if (no.toUpperCase().equals("M")) {
						return;
					}
				}
				if (1 <= memberNum && memberList.size() >= memberNum) {
					MemberVO member = memberList.get(memberNum - 1);
					readMember = member;
					readMemberView();
				} else {
					System.out.println("�Է��� �ùٸ��� �ʽ��ϴ�.");
				}

			} catch (SQLException e) {
				System.out.println("�ý��ۿ����� �߻��߽��ϴ�.\n��� �� �ٽ� �̿�ٶ��ϴ�");
			}
		}
	}

	@Override
	public void joinMemberView() {
		JoinRequest req = new JoinRequest();
		Scanner scan = new Scanner(System.in);

		System.out.println();
		System.out.println("** ���� ȭ�� **");
		System.out.println("���̵� �Է��ϼ���.");
		req.setMember_id(scan.nextLine().trim());
		System.out.println("�н����带 �Է��ϼ���.");
		req.setMember_pwd(scan.nextLine().trim());
		System.out.println("�̸��� �Է��ϼ���.");
		req.setMember_name(scan.nextLine().trim());

		try {
			service.joinMember(req);
		} catch (SQLException e) {
			System.out.println("�ý��ۿ����� �߻��߽��ϴ�.\n��� �� �ٽ� �̿�ٶ��ϴ�");
		} catch (FailToVerifiedIDException e) {
			System.out.println("�ߺ��� ���̵��Դϴ�.\n�ٽ� �õ��ϼ���.");
			System.out.println("����Ͻ÷��� ���͸� ġ����.");
			scan.nextLine();			
		}

	}

	@Override
	public void modifyMemberView() {

		ModifyRequest req = new ModifyRequest();
		req.setMember_id(readMember.getMember_id());
		req.setMember_name(readMember.getMember_name());
		req.setMember_pwd(readMember.getMember_pwd());
		req.setMember_regDate(new Date());

		Scanner scan = new Scanner(System.in);
		while (true) {
			System.out.println();
			System.out.println("** ���� ȭ�� **");

			System.out.println("���̵� : " + readMember.getMember_id());
			System.out.println("[1]�н����� : " + readMember.getMember_pwd());
			System.out.println("[2]�̸� : " + readMember.getMember_name());

			System.out.print("������ �׸��� �����Ͻÿ�.[1~2],����[s],���[c]");
			switch (scan.nextLine().trim()) {
			case "1":// �н����� ����
				System.out.println("������ �н����带 �ۼ��Ͻÿ�.");
				req.setMember_pwd(scan.nextLine().trim());
				break;
			case "2":// �̸� ����
				System.out.println("������ �̸��� �ۼ��Ͻÿ�.");
				req.setMember_name(scan.nextLine().trim());
				break;
			case "c":
			case "C":
				return;
			case "s":
			case "S":
				try {
					service.modifyMember(req);
				} catch (SQLException e) {
					System.out.println("�ý��ۿ����� �߻��߽��ϴ�.\n��� �� �ٽ� �̿�ٶ��ϴ�");
				}
				return;
			default:
				System.out.println("�Է��� �ùٸ��� �ʽ��ϴ�.");
				;
			}
		}

	}

	MemberVO readMember = null;

	@Override
	public void readMemberView() {
		while (true) {
			System.out.println();
			System.out.println("** ȸ�� �� ���� **");
			System.out.println("���̵� : " + readMember.getMember_id());
			System.out.println("�н����� : " + readMember.getMember_pwd());
			System.out.println("�̸� : " + readMember.getMember_name());
			System.out.println("����(����)��¥ : " + readMember.getMember_regDate());
			System.out.println("���� [u], ����[d], ���[c]");
			Scanner scan = new Scanner(System.in);
			switch (scan.nextLine().trim()) {
			case "u":
			case "U":
				if (SessionScope.loginUser != null) {
					modifyMemberView();
				} else {
					System.out.println("�α����� �ʿ��մϴ�.");
				}
				break;
			case "d":
			case "D":
				if (SessionScope.loginUser != null) {
					try {
						service.removeMember(readMember.getMember_id());
					} catch (SQLException e) {
						System.out.println("�ý��ۿ����� �߻��߽��ϴ�.\n��� �� �ٽ� �̿�ٶ��ϴ�");
					}
				} else {
					System.out.println("�α����� �ʿ��մϴ�.");
				}
				break;
			case "c":
			case "C":
				return;
			default:
				System.out.println("�ùٸ� �Է��� �ƴմϴ�");
			}
		}

	}

	@Override
	public void errorView() {
		// TODO Auto-generated method stub

	}

}
