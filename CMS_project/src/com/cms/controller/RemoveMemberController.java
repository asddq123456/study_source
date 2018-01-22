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

@WebServlet("/member/delete")
public class RemoveMemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url=request.getContextPath()+"/member/list";
		
		String member_id=(String)request.getParameter("member_id");
		
		MemberService service = MemberServiceImpl.getInstance();
		
		try {
			service.removeMember(member_id);
		} catch (SQLException e) {
			url="/WEB-INF/views/commons/error.jsp";
			e.printStackTrace();
			request.getRequestDispatcher(url).forward(request, response);
			return;
		}
		
		response.sendRedirect(url);
	}

}






