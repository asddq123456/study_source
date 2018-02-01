package com.cms.controller;

import java.io.IOException;
import java.io.PrintWriter;
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

@WebServlet("/member/delete")
public class RemoveMemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url=request.getContextPath()+"/member/list";
		
		HttpSession session=request.getSession();
		MemberVO loginUser=(MemberVO)session.getAttribute("loginUser");
		
		//if(SessionScope.loginUser==null){
		if(loginUser==null){
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out=response.getWriter();			
			out.print("<script>alert('로그인이 필요합니다.');</script>");
			url=request.getContextPath()+"/commons/login";
			/*response.sendRedirect(url);*/
			out.print("<script>");
			out.print("location.href='"+url+"'");
			out.print("</script>");
			return;
		}		
		
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






