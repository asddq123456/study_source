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
	<ul>
		<li>1+2 = ${1+2 }</li>
		<li>1-2 = ${1-2}</li>
		<li>2*3 = ${2*3 }</li>
		<li>4/2 = ${4/2}</li>
	</ul>
	<ul>
		<li>1&gt;=2 = ${1>=2 }</li>
		<li>1&gt;2 = ${1>2}</li>
		<li>2&lt;=3 = ${2<=3 }</li>
		<li>4&lt;2 = ${4<2}</li>
	</ul>
	<ul>
		<li>true && true = ${true && true }</li>
		<li>true || false = ${true || false }</li>		
		<li>!true = ${!true }</li>
	</ul>
	<ul>
		<li>null : ${empty null }</li>
		<li>"" : ${empty "" }</li>
	</ul>
	<ul>
		<li>(10>5) ? true : false  = ${(10>5) ? true : false }</li>		
	</ul>
</body>
</html>









