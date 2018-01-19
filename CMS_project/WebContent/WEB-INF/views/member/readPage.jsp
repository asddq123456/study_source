<%@page import="com.cms.dto.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>

<%
	MemberVO member=(MemberVO)request.getAttribute("member");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
	<div id="wrap">
		<table border="1">
			<tr>
				<td>아이디</td><td><%=member.getMember_id() %></td>
			</tr>
			<tr>
				<td>패스워드</td><td><%=member.getMember_pwd() %></td>
			</tr>
			<tr>
				<td>이름</td><td><%=member.getMember_name() %></td>
			</tr>
			<tr>
				<td>가입날짜</td><td><%=member.getMember_regDate() %></td>
			</tr>
		</table>
		<br/>
		<button id="modifyBtn">MODIFY</button>&nbsp;&nbsp;&nbsp;		
		<button id="deleteBtn" onclick="delete_go();">DELETE</button>&nbsp;&nbsp;&nbsp;
		<button id="listBtn">LIST</button>&nbsp;&nbsp;&nbsp;
	</div>
</body>
<script>
	var modifyBtn=document.getElementById("modifyBtn");
	modifyBtn.onclick=function(event){
		location.href="modify?member_id=<%=member.getMember_id()%>";
	};	
	
	function delete_go(){
		location.href="delete?member_id=<%=member.getMember_id()%>";
	}
	
	var listBtn=document.getElementById("listBtn");
	listBtn.addEventListener("click",list_go);
	
	function list_go(){
		location.href="list";
	};
</script>
</html>










