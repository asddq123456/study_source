<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
	<%
		String msg=(String)request.getAttribute("msg");
		if(msg!=null || !msg.isEmpty()){
	%>
	<h2><%=msg %></h2><br/>	
	<%
		}
	%>
	<h3>시스템 장애입니다.<br/>잠시후 이용바랍니다.</h3>
</body>
</html>










