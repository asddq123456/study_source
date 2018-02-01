<%@page import="com.cms.dto.MemberVO"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ include file="/WEB-INF/views/include/header.jsp" %>

<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/page.css" /> 

<div id="content">

	<h1>회원 리스트</h1>
	<a href="join"><button class="btn" >회원등록</button></a>
	<hr/>	
	
	
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
				<td>
					<fmt:formatDate value="${member.member_regDate }"
					pattern="yyyy-MM-dd hh:mm:ss" />
					
				</td>
			</tr>
		</c:forEach>
	</table>
</div> <!-- div#content end -->

<%@ include file="/WEB-INF/views/include/footer.jsp" %>













