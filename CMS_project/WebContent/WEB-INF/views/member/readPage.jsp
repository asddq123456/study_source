<%@page import="com.cms.dto.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ include file="/WEB-INF/views/include/header.jsp" %>

<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/page.css" /> 

<div id="content">
	<h1>회원 상세정보</h1>
	<hr/>
		<table border="1">
			<tr>
				<td>아이디</td>
				<td>${member.member_id }</td>
			</tr>
			<tr>
				<td>패스워드</td>
				<td>${member.member_pwd }</td>
			</tr>
			<tr>
				<td>이름</td>
				<td>${member.member_name }</td>
			</tr>
			<tr>
				<td>가입날짜</td>
				<td>${member.member_regDate }</td>
			</tr>
		</table>
		<br/>
		<button class="btn" id="modifyBtn">MODIFY</button>&nbsp;&nbsp;&nbsp;		
		<button class="btn" id="deleteBtn" onclick="delete_go();">DELETE</button>&nbsp;&nbsp;&nbsp;
		<button class="btn" id="listBtn">LIST</button>&nbsp;&nbsp;&nbsp;
	
<script>
	var modifyBtn=document.getElementById("modifyBtn");
	modifyBtn.onclick=function(event){
		location.href="modify?member_id=${member.member_id}";
	};	
	
	function delete_go(){
		location.href="delete?member_id=${member.member_id}";
	}
	
	var listBtn=document.getElementById("listBtn");
	listBtn.addEventListener("click",list_go);
	
	function list_go(){
		location.href="list";
	};
</script>

</div> <!-- div#content end -->

<%@ include file="/WEB-INF/views/include/footer.jsp" %>










