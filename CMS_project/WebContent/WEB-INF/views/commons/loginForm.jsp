<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>


<%@ include file="/WEB-INF/views/include/header.jsp" %>

<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/page.css" /> 

<div id="content">
	<h1>로그인</h1>
	<hr/>
	<form method="post">
		아이디 : <input type='text' name="id" value="${param.id}"	/><br/>
		패스워드 : <input type="password" name="pwd" /><br/>
		<input class="btn" type="submit" value="LOGIN" />
		&nbsp;&nbsp;&nbsp;&nbsp;
		<input class="btn" type="reset" value="RESET" />
	</form>

	<div>
		<h3 style="color:red;">${msg }</h3>
	</div>
</div> <!-- div#content end -->

<%@ include file="/WEB-INF/views/include/footer.jsp" %>










