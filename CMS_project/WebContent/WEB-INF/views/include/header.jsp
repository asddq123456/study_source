<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script
  src="http://code.jquery.com/jquery-1.12.4.min.js" ></script>
<title></title>
<style>
*{
	margin:0px;
	padding:0px;
	
	list-style:none;
}	


div#wrap{
	width:850px;		
	margin:0 auto;
	
}

div#wrap header{		
	height:200px;	
	position:relative;
	background:#ddddff;
	border-radius:15px;
	overflow:hidden;
}

div#wrap header div#head_top{	
	height:160px;	
}
div#wrap header div#head_bottom{
	width:100%;
	height:35px;	
	position:absolute;
	left:0;
	bottom:0;
	line-height:35px;
}

div#head_bottom > button{
	margin-left:10px;
}

div#wrap div#top_menu{
	height:30px;
	line-height:30px;
}

div#wrap div#top_menu ul{
	overflow:hidden;
	background:gray;
}
div#wrap div#top_menu ul>li{
	float:right;
	margin-right:15px;
	font-weight:bold;
	font-size:12px;
	color:#efefef;
} 

div#wrap div#head_top div#title{
	height:135px;
	line-height:135px;
}

div#wrap div#head_top div#title>h1{
	font-size:54px;
	text-align:center;
}

.btn{
	height:30px;
	padding:0 10px;
	border-radius:7px;
	border:1px solid white;
	background:gray;
	color:white;
	font-weight:bold;
	cursor:pointer;
	
}

</style>
</head>
<body>
	<div id="wrap">
		<header>
			<div id="head_top">				
				<div id="top_menu">				
					<ul>						
						<li id="site">회원관리 | 상품관리 | 게시판관리</li>
						<li id="log">${loginUser.member_name }님 반갑습니다.</li>
						<li>
							<c:choose>
								<c:when test="${empty loginUser }">
									<a href="<%=request.getContextPath() %>/commons/login">
									<button class="btn" >Login</button></a>
								</c:when>
								
								<c:otherwise>									
									<a href="<%=request.getContextPath() %>/commons/logout">
									<button class="btn" style="height:25px;">Logout</button></a>
								</c:otherwise>
							</c:choose>
						</li>
					</ul>					
				</div>
				<div id="title">
					<h1>관리자 페이지</h1>
				</div>
			</div>
			<div id="head_bottom">
				<button class="btn" id="memberBtn">회원리스트</button>
				<button class="btn" id="productBtn">상품리스트</button>
			</div>
		</header>
	
	
	
	
	
	
	
	
	
	
	
	
	