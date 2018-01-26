package com.cms.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cms.dto.MemberVO;
import com.cms.service.MemberService;
import com.cms.service.MemberServiceImpl;
import com.test.view.ViewResolver;

@WebServlet("/member/readPage")
public class ReadPageMemberController extends HttpServlet {
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url="/member/readPage";
		String member_id=request.getParameter("member_id");
		MemberService service=MemberServiceImpl.getInstance();
		
		try {
			MemberVO member=service.getMemberByID(member_id);
			request.setAttribute("member", member);
			
		} catch (SQLException e) {
			url="/commons/error";
			request.setAttribute("msg", "데이터베이스 에러발생");
			e.printStackTrace();
		}
		
		ViewResolver.view(url, request, response);
		
	}

}





