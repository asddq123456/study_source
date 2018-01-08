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
			System.out.println("********  회원 관리 프로그램 Ver 1.0  *******");
			System.out.println();
			if (SessionScope.loginUser != null) {
				System.out.println("[1] 로그아웃");
			} else {
				System.out.println("[1] 로그인");
			}
			System.out.println("[2] 회원리스트");
			System.out.println("[3] 회원등록");
			System.out.println("[4] 종료");
			System.out.print("메뉴를 선택하시오.[1~4] : _");

			Scanner scan = new Scanner(System.in);
			switch (scan.nextLine().trim()) {
			case "1": // 로그인
				if (SessionScope.loginUser == null) {
					loginView();
				} else {
					try {
						service.logout();						
						System.out.println("로그아웃 하셨습니다.");
					} catch (SQLException e) {
						System.out.println("로그아웃에 문제가 발생했습니다.\n" + "프로그램을 종료하시기 바랍니다..");
					} catch (NullLoginUserException e) {
						System.out.println("로그인한 사용자가 없습니다.");
					}
				}
				break;
			case "2": // 회원리스트
				memberListView();
				break;
			case "3": // 회원등록
				if (SessionScope.loginUser != null) {
					joinMemberView();
				} else {
					System.out.println("로그인이 필요한 서비스입니다");
					System.out.println("계속하려면 엔터를 치세요.");
					scan.nextLine();
				}
				break;
			case "4": // 종료
				System.out.println("프로그램을 종료합니다.");
				return;
			default:
				System.out.println("입력이 올바르지 않습니다.");
			}
		}
	}

	@Override
	public void loginView() {
		Scanner scan = new Scanner(System.in);
		LoginRequest req = new LoginRequest();
		System.out.println();
		System.out.println("** 로그인 화면 **");
		System.out.println("아이디를 입력하세요.");
		req.setId(scan.nextLine().trim());
		System.out.println("패스워드를 입력하세요.");
		req.setPwd(scan.nextLine().trim());

		try {
			service.login(req);
			System.out.println("로그인에 성공했습니다.");
			System.out.println("계속하려면 엔터를 치세요.");
			scan.nextLine();
		} catch (SQLException e) {
			System.out.println("시스템오류가 발생했습니다.\n잠시 후 다시 이용바랍니다");
		} catch (NotFoundIDException e) {
			System.out.println("존재하지 않는 아이디입니다.\n다시 시도하세요.");
		} catch (InvalidPasswordException e) {
			System.out.println("패스워드가 불일치합니다..\n다시 시도하세요.");
		}

	}

	@Override
	public void memberListView() {
		while (true) {
			try {
				List<MemberVO> memberList = service.getMemberList();

				System.out.println("순번\t아이디\t패스워드\t이름\t날짜");
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
				System.out.println("상세보기 리스트 번호를 입력하세요.(초기메뉴 : M)");
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
					System.out.println("입력이 올바르지 않습니다.");
				}

			} catch (SQLException e) {
				System.out.println("시스템오류가 발생했습니다.\n잠시 후 다시 이용바랍니다");
			}
		}
	}

	@Override
	public void joinMemberView() {
		JoinRequest req = new JoinRequest();
		Scanner scan = new Scanner(System.in);

		System.out.println();
		System.out.println("** 가입 화면 **");
		System.out.println("아이디를 입력하세요.");
		req.setMember_id(scan.nextLine().trim());
		System.out.println("패스워드를 입력하세요.");
		req.setMember_pwd(scan.nextLine().trim());
		System.out.println("이름을 입력하세요.");
		req.setMember_name(scan.nextLine().trim());

		try {
			service.joinMember(req);
		} catch (SQLException e) {
			System.out.println("시스템오류가 발생했습니다.\n잠시 후 다시 이용바랍니다");
		} catch (FailToVerifiedIDException e) {
			System.out.println("중복된 아이디입니다.\n다시 시도하세요.");
			System.out.println("계속하시려면 엔터를 치세요.");
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
			System.out.println("** 수정 화면 **");

			System.out.println("아이디 : " + readMember.getMember_id());
			System.out.println("[1]패스워드 : " + readMember.getMember_pwd());
			System.out.println("[2]이름 : " + readMember.getMember_name());

			System.out.print("수정할 항목을 선택하시오.[1~2],저장[s],취소[c]");
			switch (scan.nextLine().trim()) {
			case "1":// 패스워드 수정
				System.out.println("수정할 패스워드를 작성하시오.");
				req.setMember_pwd(scan.nextLine().trim());
				break;
			case "2":// 이름 수정
				System.out.println("수정할 이름을 작성하시오.");
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
					System.out.println("시스템오류가 발생했습니다.\n잠시 후 다시 이용바랍니다");
				}
				return;
			default:
				System.out.println("입력이 올바르지 않습니다.");
				;
			}
		}

	}

	MemberVO readMember = null;

	@Override
	public void readMemberView() {
		while (true) {
			System.out.println();
			System.out.println("** 회원 상세 보기 **");
			System.out.println("아이디 : " + readMember.getMember_id());
			System.out.println("패스워드 : " + readMember.getMember_pwd());
			System.out.println("이름 : " + readMember.getMember_name());
			System.out.println("가입(수정)날짜 : " + readMember.getMember_regDate());
			System.out.println("수정 [u], 삭제[d], 취소[c]");
			Scanner scan = new Scanner(System.in);
			switch (scan.nextLine().trim()) {
			case "u":
			case "U":
				if (SessionScope.loginUser != null) {
					modifyMemberView();
				} else {
					System.out.println("로그인이 필요합니다.");
				}
				break;
			case "d":
			case "D":
				if (SessionScope.loginUser != null) {
					try {
						service.removeMember(readMember.getMember_id());
					} catch (SQLException e) {
						System.out.println("시스템오류가 발생했습니다.\n잠시 후 다시 이용바랍니다");
					}
				} else {
					System.out.println("로그인이 필요합니다.");
				}
				break;
			case "c":
			case "C":
				return;
			default:
				System.out.println("올바른 입력이 아닙니다");
			}
		}

	}

	@Override
	public void errorView() {
		// TODO Auto-generated method stub

	}

}
