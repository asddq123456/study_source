<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="id" value="mimi" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
	<%-- <%
		String id=(String)pageContext.getAttribute("id");
		if(id.equals("mimi")){
	%>
		<script>
			alert("로그인에 성공했습니다.");
		</script>
	<%	
		}
	%> --%>
	<c:if test="${id eq 'mimi' }">
		<script>
			alert("로그인에 성공했습니다.");
		</script>
	</c:if>
</body>
</html>










