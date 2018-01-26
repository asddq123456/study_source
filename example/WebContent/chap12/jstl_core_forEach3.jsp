<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
	List<String> menuList=new ArrayList<String>();
	menuList.add("한식");
	menuList.add("중식");
	menuList.add("일식");
	menuList.add("양식");
%>
<style>

#menu1{
	background:red;
}
#menu2{
	background:orange;
}
#menu3{
	background:yellow;
}
#menu4{
	background:green;
}
</style>

<ul>
	<c:forEach var="menu" items="<%=menuList %>" varStatus="st">
		<li id="menu${st.count }"> ${menu }</li>	
	</c:forEach>
</ul>





