<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>

<%
	pageContext.setAttribute("msg","안녕하세요");
	request.setAttribute("msg", "반갑습니다.");
	session.setAttribute("msg","오늘 날씨가 매우 춥습니다.");
	application.setAttribute("msg","건강에 유의하세요.");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
	<h1>${sessionScope.msg }</h1>
</body>
</html>







