<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>

<%
	String id=request.getParameter("id");
	String msg=(String)request.getAttribute("msg");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
	<form method="post">
		아이디 : <input type='text' name="id" 
		<% if(id!=null){ %>
		value="<%=id %>"
		<% } %> 
		/><br/>
		패스워드 : <input type="password" name="pwd" /><br/>
		<input type="submit" value="LOGIN" />
		&nbsp;&nbsp;&nbsp;&nbsp;
		<input type="reset" value="RESET" />
	</form>
	
	<% if(msg!=null){ %>
	<div>
		<h3 style="color:red;"><%=msg %></h3>
	</div>
	<% } %>
</body>
</html>











