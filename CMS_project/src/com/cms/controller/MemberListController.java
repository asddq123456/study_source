package com.cms.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cms.dto.MemberVO;
import com.cms.service.MemberService;
import com.cms.service.MemberServiceImpl;
import com.jdbc.scope.SessionScope;
import com.test.view.ViewResolver;


@WebServlet("/member/list")
public class MemberListController extends HttpServlet {
	private static final long serialVersionUID = 1L;      
  
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url="/member/list";
		
		MemberService memberService=MemberServiceImpl.getInstance();
		
		MemberVO loginUser=SessionScope.loginUser;
		
		request.setAttribute("loginUser", loginUser);
		
		
		try {
			List<MemberVO> memberList=memberService.getMemberList();
			request.setAttribute("memberList", memberList);
		} catch (SQLException e) {
			e.printStackTrace();
			request.setAttribute("error", "시스템에러가 발생했습니다.");
		}
		
		ViewResolver.view(url, request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}








