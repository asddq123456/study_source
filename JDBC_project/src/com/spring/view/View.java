package com.spring.view;

public interface View {
	
	//메인화면
	void mainView();

	//로그인	
	void loginView();
	
	//회원리스트화면
	void memberListView();
	
	//회원가입화면
	void joinMemberView();
	
	//회원수정화면
	void modifyMemberView();
	
	//회원상세화면
	void readMemberView();
	
	//에러화면
	void errorView();
	
	
	
}
