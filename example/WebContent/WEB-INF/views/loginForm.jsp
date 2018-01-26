<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>

<%
	String id=request.getParameter("id");
	String msg=(String)request.getAttribute("msg");
%>

<body>
	<form action="/login" method="post">
		아이디 : <input type="text" name="id"
		
		<%
			if(id!=null){
				out.print("value='"+id+"' ");
			}
		%>		
		
		 /><br/>
		패스워드 : <input type="password" name="pwd" /><br/>
		<input type="submit" value="로그인" />
		&nbsp;&nbsp;&nbsp;&nbsp;
		<input type="reset" value="취소" />
	</form>
	<div id="msg">
		<h3 style="color:red; font-weight:bold;">
			<%
				if(msg!=null){
					out.print(msg);
				}
			%>
		</h3>
	</div>
</body>
</html>








