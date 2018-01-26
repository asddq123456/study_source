<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
이름 : memNm  : ${joinReq.memNm }<br/>
아이디 : memId : ${joinReq.memId }<br/> 
패스워드 : memPwd : ${joinReq.memPwd }<br/>
이메일 : email : ${joinReq.email }<br/>
통신사 : entCmmnClf : ${joinReq.entCmmnClf }<br/>
핸드폰번호 : prtblTlphnNo : ${joinReq.prtblTlphnNo }<br/>
SMS 수신 : smsRcvAgree : ${joinReq.smsRcvAgree }<br/>
email수신:emailRcvAgree : ${joinReq.emailRcvAgree }<br/>

<c:remove var="joinReq"/>
</body>
</html>





