package com.jdbc.main;

import com.spring.dao.MemberDAO;
import com.spring.dao.MemberDAOImpl;
import com.spring.service.MemberService;
import com.spring.service.MemberServiceImpl;
import com.spring.view.View;
import com.spring.view.ViewImpl;

public class Main {

	static private View view;
	static private MemberDAO memberDAO;
	static private MemberService memberService;
	
	static {
		memberDAO=MemberDAOImpl.getInstance();
		
		memberService=MemberServiceImpl.getInstance();
		((MemberServiceImpl)memberService).setMemberDAO(memberDAO);
		
		view = ViewImpl.getInstance();
		((ViewImpl)view).setService(memberService);
	}
	
	public static void main(String[] args) throws Exception{
				
		view.mainView();
	}

}




