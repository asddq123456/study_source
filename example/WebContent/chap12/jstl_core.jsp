<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<%-- <% 
	pageContext.setAttribute("str", "mimi");
%>
 --%>
 
<c:set var="str" value="page" scope="page" /> 
<c:set var="str" value="request" scope="request" />
<c:set var="str" value="session" scope="session" />

<c:remove var="str" scope="page"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
	<h1>${str }</h1>
</body>
</html>





