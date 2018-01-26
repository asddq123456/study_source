<%@page import="java.io.PrintWriter"%>
<%@page import="java.util.Calendar"%>
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
	<%! Calendar cal=Calendar.getInstance();
		public void printCalendar(Calendar cal, PrintWriter out){
			out.print("오늘은 ");
			out.print(cal.get(Calendar.YEAR)+"년 ");
			out.print((cal.get(Calendar.MONTH)+1)+"월 ");
			out.print(cal.get(Calendar.DATE)+"일 ");
			out.print("입니다.");
		}
	%>
	<%
		printCalendar(cal,response.getWriter());
	%>
	
	오늘은
	<%= cal.get(Calendar.YEAR) %>년
	<%= cal.get(Calendar.MONTH)+1 %>월
	<%= cal.get(Calendar.DATE) %>일
	입니다.
</body>
</html>











