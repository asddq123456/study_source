package com.jdbc.main;

import com.jdbc.source.DataSource;
import com.jdbc.source.DataSourceDBCP2;
import com.spring.dao.MemberDAO;
import com.spring.dao.MemberDAOImpl;
import com.spring.service.MemberService;
import com.spring.service.MemberServiceImpl;
import com.spring.view.View;
import com.spring.view.ViewImpl;

public class Main {
	
	static private DataSource dataSource;
	static private MemberDAO memberDAO;
	static private MemberService memberService;
	static private View view;
	
	static {
		
		//DataSource dataSource=DataSource.getInstance();
		DataSourceDBCP2 dataSource=DataSourceDBCP2.getInstance();
		dataSource.setUrl("jdbc:oracle:thin:@127.0.0.1:1521:XE");
				
		memberDAO=MemberDAOImpl.getInstance();
		((MemberDAOImpl)memberDAO).setDataSource(dataSource);
		
		memberService=MemberServiceImpl.getInstance();
		((MemberServiceImpl)memberService).setMemberDAO(memberDAO);
		
		view = ViewImpl.getInstance();
		((ViewImpl)view).setService(memberService);
	}
	
	public static void main(String[] args) throws Exception{
				
		view.mainView();
	}

}




