<%@page import="java.util.StringTokenizer"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
	String color="red,yellow,green,blue";

	StringTokenizer token=new StringTokenizer(color,",");
	while(token.hasMoreTokens()){
		out.println(token.nextToken()+"<br/>");
	}
%>
<hr/>
<c:forTokens var="token" items="<%=color %>" delims=",">
	${token }<br/>
</c:forTokens>










