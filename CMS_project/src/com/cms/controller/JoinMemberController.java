package com.cms.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cms.service.MemberService;
import com.cms.service.MemberServiceImpl;
import com.jdbc.exception.FailToVerifiedIDException;

@WebServlet("/member/join")
public class JoinMemberController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url="/WEB-INF/views/member/joinForm.jsp";
		System.out.println("!!");
		request.getRequestDispatcher(url).forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
		String url=request.getContextPath()+"/member/list";
		
		MemberService service=MemberServiceImpl.getInstance();
				
		JoinRequest joinReq=new JoinRequest();
		joinReq.setMember_id(request.getParameter("member_id"));
		joinReq.setMember_pwd(request.getParameter("member_pwd"));
		joinReq.setMember_name(request.getParameter("member_name"));
		
		try {
			service.joinMember(joinReq);
		} catch (SQLException e) {
			url="/WEB-INF/views/commons/error.jsp";			
			e.printStackTrace();
			request.getRequestDispatcher(url).forward(request, response);
			return;
		} catch (FailToVerifiedIDException e) {
			url="/WEB-INF/views/member/joinForm.jsp";
			request.setAttribute("msg", "아이디 중복입니다.");
			e.printStackTrace();
			request.getRequestDispatcher(url).forward(request, response);
			return;
		}
		
		response.sendRedirect(url);
	}

}
















