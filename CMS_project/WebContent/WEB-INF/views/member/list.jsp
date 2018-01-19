<%@page import="com.cms.dto.MemberVO"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>

<%
	List<MemberVO> memberList
	=(List<MemberVO>)request.getAttribute("memberList");
	String error=(String)request.getAttribute("error");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
	<a href="join"><button>회원등록</button></a>
	<table border="1">
		<tr>
			<th>아이디</th>
			<th>패스워드</th>
			<th>이름</th>
			<th>가입날짜</th>
		</tr>
		<%
			for(MemberVO member:memberList){
		%>
		<tr>
			<td><%=member.getMember_id() %></td>
			<td><%=member.getMember_pwd() %></td>
			<td>
				<a href="readPage?member_id=<%=member.getMember_id()%>">
					<%=member.getMember_name() %>
				</a>
			</td>
			<td><%=member.getMember_regDate() %></td>
		</tr>
		<%
			}
		%>
	</table>
</body>
</html>














