<%@page import="com.cms.dto.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>

<%
	MemberVO member = (MemberVO) request.getAttribute("member");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
	<div id="wrap">
		<form name="frm">
			<table border="1">
				<tr>
					<td>아이디</td>
					<td>
						<input type="text" name="member_id"
							  readonly style="background:#aaaaaa;"
							  value="<%=member.getMember_id()%>" />
					</td>
				</tr>
				<tr>
					<td>패스워드</td>
					<td>
						<input type="password" name="member_pwd"
						value="<%=member.getMember_pwd()%>"/>
					</td>
				</tr>
				<tr>
					<td>이름</td>
					<td>
						<input type="text" name="member_name"
						value="<%=member.getMember_name()%>" />
					</td>
				</tr>				
			</table>
		</form>
		<br />
		<button id="saveBtn">SAVE</button>
		&nbsp;&nbsp;&nbsp;
		<button id="cancelBtn" onclick="cancel_go();">CANCEL</button>
		&nbsp;&nbsp;&nbsp;
		<button id="listBtn">LIST</button>
		&nbsp;&nbsp;&nbsp;
	</div>
</body>
<script>
	document.getElementById("saveBtn").onclick = function(event) {
		document.frm.action="modify";
		document.frm.method="post";
		document.frm.submit();
	};
	document.getElementById("cancelBtn").onclick = function(event) {
		history.go(-1);
	};
	document.getElementById("listBtn").onclick = function(event) {
		location.href="list";
	};
</script>
</html>










