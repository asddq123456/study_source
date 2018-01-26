<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<style>
*{
	margin:0;
	padding:0;
	font-size:12px;
}
div#wrap{
	width:800px;	
	margin:0 auto;
}

div#wrap>div{
	height:300px;
	overflow:scroll;
	margin-bottom:20px;
}
</style>

<c:import url="https://www.daum.net" var="daum" />
<c:import url="http://www.google.com" var="google" scope="session" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
	<div id="wrap">
		<div id="naver">
			<c:import url="https://www.naver.com" />
		</div>
		<div id="daum">${daum }</div>
		<div id="google">${sessionScope.google }</div>
	</div>
</body>
</html>









