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
	<form method="post">
		아이디 : <input type='text' name="id" value="${param.id}"	/><br/>
		패스워드 : <input type="password" name="pwd" /><br/>
		<input type="submit" value="LOGIN" />
		&nbsp;&nbsp;&nbsp;&nbsp;
		<input type="reset" value="RESET" />
	</form>

	<div>
		<h3 style="color:red;">${msg }</h3>
	</div>

</body>
</html>











