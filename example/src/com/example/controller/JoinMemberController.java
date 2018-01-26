package com.example.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/member/join")
public class JoinMemberController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url="/chap12/joinForm.jsp";
		request.getRequestDispatcher(url).forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String url="/member/joinSuccess";
		
		String memNm=request.getParameter("memNm");
		String memId=request.getParameter("memId");
		String memPwd=request.getParameter("memPwd");
		String email=request.getParameter("email");
		String entCmmnClf=request.getParameter("entCmmnClf");
		String prtblTlphnNo=request.getParameter("prtblTlphnNo");
		String smsRcvAgree=request.getParameter("smsRcvAgree");
		String emailRcvAgree=request.getParameter("emailRcvAgree");
		
		JoinRequest joinReq=
		new JoinRequest(memNm,memId,memPwd,email,entCmmnClf,
				prtblTlphnNo,smsRcvAgree,emailRcvAgree);
		
		HttpSession session=request.getSession();
		
		session.setAttribute("joinReq", joinReq);		
		//request.getRequestDispatcher(url).forward(request, response);
		response.sendRedirect(url);
	}

}







