package com.cms.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cms.dto.MemberVO;
import com.cms.service.MemberService;
import com.cms.service.MemberServiceImpl;
import com.jdbc.scope.SessionScope;

@WebServlet("/member/modify")
public class ModifyMemberController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String url="/WEB-INF/views/member/modifyForm.jsp";
		
		if(SessionScope.loginUser==null){
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
		
		if(member_id!=null){
			MemberService service=MemberServiceImpl.getInstance();
			try {
				MemberVO member=service.getMemberByID(member_id);
				request.setAttribute("member", member);				
			} catch (SQLException e) {				
				e.printStackTrace();
			}
		}else{
			return;
		}
		request.getRequestDispatcher(url).forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String url=request.getContextPath()+"/member/list";
		
		ModifyRequest modifyReq=new ModifyRequest();
		modifyReq.setMember_id(request.getParameter("member_id"));
		modifyReq.setMember_pwd(request.getParameter("member_pwd"));
		modifyReq.setMember_name(request.getParameter("member_name"));
		modifyReq.setMember_regDate(new Date());
		
		MemberService service = MemberServiceImpl.getInstance();
		
		try {
			service.modifyMember(modifyReq);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		response.sendRedirect(url);
		
	}

}







