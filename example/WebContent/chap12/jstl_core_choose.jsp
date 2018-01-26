<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
	String number=request.getParameter("number");
	String msg="";
	if(number.equals("3")){
		msg="경환상~~! 오갱끼데스까~~!!";
	}else{
		msg="바보~!";
	}
	pageContext.setAttribute("msg", msg);
%>

<c:choose>
	<c:when test="${param.number eq '3' }">
		<c:set var="msg" value="경환상..오갱끼데스까~!" />
	</c:when>
	<c:otherwise>
		<c:set var="msg" value="바보" />
	</c:otherwise>
</c:choose>
<script>
	alert("${msg}");
</script>











