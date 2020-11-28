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
	<script src="https://developers.kakao.com/sdk/js/kakao.min.js" ></script>
</head>
<body class="bg">

	<section id="main">
		<header>
			<span class="avatar"><img src="<c:url value='/resources/images/avatar.jpg' />" alt=""></span>
			<h1>Beam Us UP</h1>
			<p>Project management Board</p>
		</header>
		<hr>
		<h2>Right now!</h2>
		<form class="form-signin" method="post" id="myForm">
			<input type="hidden"  name="${_csrf.parameterName}"   value="${_csrf.token}">
			<p>
				<label for="username" class="sr-only">Username</label>
				<input type="text" id="username" name="username" class="form-control" placeholder="Usernameeeee" required="" autofocus="">
			</p>
			<p>
				<label for="password" class="sr-only">Password</label>
				<input type="password" id="password" name="password" class="form-control" placeholder="Passworddddd" required="">
			</p>
			<p>
				<div id="join">
					<h6>간단하게 가입하실래요?</h6>
				</div>
			</p>
			<button type="button" class="btn btn-lg btn-primary btn-block" id="btnLogin">login</button>
		</form>
		        
	       <a id="custom-login-btn" href="javascript:loginWithKakao()">
			  <img
			    src="//k.kakaocdn.net/14/dn/btqCn0WEmI3/nijroPfbpCa4at5EIsjyf0/o.jpg"
			    width="222"
			  />
			</a>
	</section>
</body>
<script src="<c:url value='/resources/js/common/common.js'/>" charset="utf-8"></script>
<script src="<c:url value='/resources/js/user/userLogin.js'/>" charset="utf-8"></script>
<script src="<c:url value='/resources/js/login/kakaoLogin.js'/>" charset="utf-8"></script>


</html>