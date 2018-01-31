<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ include file="/WEB-INF/views/include/header.jsp" %>

<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/page.css" /> 

<div id="content">
	<h1>회원 등록</h1>
	<hr/>
	<form action="join" method="post">
		아이디 : <input type="text" name="member_id" value="${param.member_id}" /><br/>
		패스워드 : <input type="password" name="member_pwd"/><br/>
		이름 : <input type="text" name="member_name" /><br/>
		<input type="submit" value="가입하기" />
		&nbsp;&nbsp;&nbsp;&nbsp;
		<input type="reset" value="취소하기" />
		&nbsp;&nbsp;&nbsp;
		<input class="btn" type="button" value="목록으로" 
			onclick="javascript:location.href='list';" />
	</form>

</div>
<c:if test="${!empty msg }">
	<script>
		alert("${msg}");
	</script>
</c:if>


<%@ include file="/WEB-INF/views/include/footer.jsp" %>












