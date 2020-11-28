<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html lang="en">
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<meta name="description" content="">
	<meta name="author" content="">
	<title>Please login in</title>
	<link href="<c:url value='/resources/css/main.css' />" rel="stylesheet">
</head>
<body class="bg">
	<section id="main">
		<header>
			<span class="avatar"><img src="<c:url value='/resources/images/avatar.jpg' />" alt=""></span>
			<h1>Beam Us UP</h1>
			<p>Project management Board</p>
		</header>
		<hr>
		<h2>간단한 회원가입</h2>
		<form class="form-signin" method="post" id="myForm">
			<input type="hidden" name="role" id="role" value="USER">
			<input type="text" name="username" id="username" placeholder="아이디를 입력하세요">
			<input type="password" name="password" id="password" placeholder="비밀번호를 입력하세요">
			
			<button type="button" class="btn btn-lg btn-primary btn-block" id="btnJoin">join</button>
		</form>
	</section>
</body>
<script src="<c:url value='/resources/js/user/userJoin.js'/>" charset="utf-8"></script>
</html>