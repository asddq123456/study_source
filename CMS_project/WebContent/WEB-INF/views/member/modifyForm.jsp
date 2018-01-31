<%@page import="com.cms.dto.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ include file="/WEB-INF/views/include/header.jsp" %>

<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/page.css" /> 

<div id="content">
	<h1>회원정보 수정</h1>
	<form name="frm">
		<table border="1">
			<tr>
				<td>아이디</td>
				<td>
					<input type="text" name="member_id"
						  readonly style="background:#aaaaaa;"
						  value="${member.member_id }" />
				</td>
			</tr>
			<tr>
				<td>패스워드</td>
				<td>
					<input type="password" name="member_pwd"
					value="${member.member_pwd }"/>
				</td>
			</tr>
			<tr>
				<td>이름</td>
				<td>
					<input type="text" name="member_name"
					value="${member.member_name }" />
				</td>
			</tr>				
		</table>
	</form>
	<br />
	<button class="btn" id="saveBtn">SAVE</button>
	&nbsp;&nbsp;&nbsp;
	<button class="btn" id="cancelBtn" onclick="cancel_go();">CANCEL</button>
	&nbsp;&nbsp;&nbsp;
	<button class="btn" id="listBtn">LIST</button>
	&nbsp;&nbsp;&nbsp;


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

</div> <!-- div#content end -->

<%@ include file="/WEB-INF/views/include/footer.jsp" %>










