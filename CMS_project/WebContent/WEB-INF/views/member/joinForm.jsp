<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
	<form action="join" method="post">
		아이디 : <input type="text" name="member_id" /><br/>
		패스워드 : <input type="password" name="member_pwd"/><br/>
		이름 : <input type="text" name="member_name" /><br/>
		<input type="submit" value="가입하기" />
		&nbsp;&nbsp;&nbsp;&nbsp;
		<input type="reset" value="취소하기" />
		&nbsp;&nbsp;&nbsp;
		<input type="button" value="목록으로" 
			onclick="javascript:location.href='list';" />
	</form>
</body>
<%
	String msg=(String)request.getAttribute("msg");
	if(msg!=null){		
%>
<script>
	alert("<%=msg%>");
</script>
<%
	}
%>
</html>














