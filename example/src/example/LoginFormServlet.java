package example;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class LoginFormServlet extends HttpServlet {

	@Override
	public void init() throws ServletException {
		System.out.println("LoginFormServlet 시작...");
	}

	@Override
	protected void doGet(HttpServletRequest req,
			HttpServletResponse resp) throws ServletException, IOException {
		
		String url="/WEB-INF/views/loginForm.jsp";
		
		req.getRequestDispatcher(url).forward(req,resp);
		
	}

	@Override
	protected void doPost(HttpServletRequest req, 
			HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8");
		
		String id=req.getParameter("id");
		String pwd=req.getParameter("pwd");
		
		PrintWriter out=resp.getWriter();
		if(id.equals("mimi") && pwd.equals("mimi")){
			req.getRequestDispatcher("/WEB-INF/views/login.jsp")
			.forward(req,resp);
		}else{
			req.setAttribute("msg", "아이디/패스워드가 일치하지않습니다");
			req.getRequestDispatcher("/WEB-INF/views/loginForm.jsp")
			.forward(req, resp);
		}		
	}

	@Override
	public void destroy() {
		System.out.println("LoginFormServlet을 종료.....");
	}

}
