<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>

<%
	List<String> menu=new ArrayList<String>();
	menu.add("<ul>");
	menu.add("<li>한식</li>");
	menu.add("<li>중식</li>");
	menu.add("<li>일식</li>");
	menu.add("</ul>");
	
	for(String str:menu){
		out.println(str);
	}
%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="menu" value="<%=menu %>"/>
<c:forEach var="str" items="${menu }"  varStatus="status" >
	${str }
</c:forEach>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>

</body>
</html>