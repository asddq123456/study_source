<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>

<%
	String str="금일 팀장 미팅있습니다. 5시40분 교무실로....";
	request.setAttribute("str", str);

%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
	<ul>
		<li>스크립트릿 : <% out.print(request.getAttribute("str")); %> </li>
		<li>표현식 : <%=request.getAttribute("str") %></li>
		<li>EL문 : ${str }</li>
	</ul>
</body>
</html>






