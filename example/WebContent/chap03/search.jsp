<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>

<%
                                                                  	String searchKey=request.getParameter("searchKey");
%>
	
<script>

	location.href="https://search.naver.com/search.naver?where=nexearch&sm=top_hty&fbm=1&ie=utf8&query=<%=searchKey%>";             

</script>