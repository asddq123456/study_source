<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>

<%
	int sum=0;
	for(int i=1;i<11;i++){
		if(i%2!=0){
			sum+=i;		
		}
	}
	out.print("<h1>"+sum+"</h1>");
%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="sum" value="0" />
<c:forEach var="i" begin="1" end="10" step="1">
	<c:if test="${i%2 != 0 }">
		<c:set var="sum" value="${sum+i }"/>
	</c:if>	
</c:forEach>
<h1>${sum }</h1>

<hr/>

<c:forEach var="dan" begin="2" end="9" step="1">
	<c:forEach var="gop" begin="1" end="9" step="1" >
		${dan } * ${gop } = ${dan*gop }<br/>
	</c:forEach>
</c:forEach>
















