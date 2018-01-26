<%@page import="com.cms.dto.MemberVO"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
	<a href="join"><button>회원등록</button></a>
		
	<c:choose>
		<c:when test="${empty loginUser }">
			<a href="<%=request.getContextPath() %>/commons/login">
			<button>Login</button></a>
		</c:when>
		
		<c:otherwise>
			${loginUser.member_name }님 반갑습니다.
			<a href="<%=request.getContextPath() %>/commons/logout">
			<button>Logout</button></a>
		</c:otherwise>
	</c:choose>
	
	<table border="1">
		<tr>
			<th>아이디</th>
			<th>패스워드</th>
			<th>이름</th>
			<th>가입날짜</th>
		</tr>
		
		<c:forEach var="member" items="${memberList }">
			<tr>
				<td>${member.member_id }</td>
				<td>${member.member_pwd }</td>
				<td>
				<a href="readPage?member_id=${member.member_id }">
					${member.member_name }
				</a>
				</td>
				<td>${member.member_regDate }</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>














