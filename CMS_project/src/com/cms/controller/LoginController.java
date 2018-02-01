package com.cms.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cms.dto.MemberVO;
import com.cms.service.MemberService;
import com.cms.service.MemberServiceImpl;
import com.jdbc.exception.InvalidPasswordException;
import com.jdbc.exception.NotFoundIDException;
import com.test.view.ViewResolver;

@WebServlet("/commons/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url="/commons/loginForm";
		ViewResolver.view(url, request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String id=request.getParameter("id");
		String pwd=request.getParameter("pwd");
		
		LoginRequest logReq=new LoginRequest(id,pwd);
		
		MemberService service=MemberServiceImpl.getInstance();
		
		String url="redirect:/member/list";
		
		HttpSession session=request.getSession();
		
		
		try {
			MemberVO member=service.login(logReq);
			session.setAttribute("loginUser", member);			
		} catch (SQLException e) {
			url="/commons/error";
			request.setAttribute("msg", "데이터베이스 장애입니다.");
			e.printStackTrace();
		} catch (NotFoundIDException e) {
			url="/commons/loginForm";
			request.setAttribute("msg", "아이디가 존재하지 않습니다.");
			e.printStackTrace();
		} catch (InvalidPasswordException e) {
			url="/commons/loginForm";
			request.setAttribute("msg", "패스워드가 일치하지 않습니다.");
			e.printStackTrace();
		}
		
		ViewResolver.view(url, request, response);
		
	}

}







