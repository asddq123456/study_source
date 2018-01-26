package com.cms.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cms.service.MemberService;
import com.cms.service.MemberServiceImpl;
import com.jdbc.exception.FailToVerifiedIDException;
import com.test.view.ViewResolver;

@WebServlet("/member/join")
public class JoinMemberController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url="/member/joinForm";		
		ViewResolver.view(url, request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
		String url="redirect:/member/list";
		
		MemberService service=MemberServiceImpl.getInstance();
				
		JoinRequest joinReq=new JoinRequest();
		joinReq.setMember_id(request.getParameter("member_id"));
		joinReq.setMember_pwd(request.getParameter("member_pwd"));
		joinReq.setMember_name(request.getParameter("member_name"));
		
		try {
			service.joinMember(joinReq);
		} catch (SQLException e) {
			url="/commons/error";			
			e.printStackTrace();
		} catch (FailToVerifiedIDException e) {
			url="/member/joinForm";
			request.setAttribute("msg", "아이디 중복입니다.");			
			e.printStackTrace();
		}
		
		/*response.sendRedirect(url);*/
		ViewResolver.view(url, request, response);
	}

}
















