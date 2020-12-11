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
	<script src="https://developers.kakao.com/sdk/js/kakao.min.js" ></script>
</head>
<body>
<div class="main-wrapper">
	<article class="post px-3 py-5 p-md-5">
		<hr>
		<h2>Right now!</h2>
		<form class="form-signin" method="post" id="myForm">
			<input type="hidden"  name="${_csrf.parameterName}"   value="${_csrf.token}">
			<div class="form-group">
				<label class="control-label col-sm-2" for="username">Username</label>
				<div class="col-sm-3">
					<input type="text" id="username" name="username" class="form-control" placeholder="Usernameeeee" required="" autofocus="">
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="password">Password</label>
				<div class="col-sm-3">
					<input type="password" id="password" name="password" class="form-control" placeholder="Passworddddd" required="">
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-3">
					<div class="btn-icon">
						<button type="button" id="join" data="${data.IDX}" class="btn-li new-btn"><i class="fa fa-sign-language"></i>회원가입</button>
						<button type="button" id="btnLogin" data="${data.IDX}" class="btn-li new-btn"><i class="fa fa-sign-in-alt"></i>로그인</button>
					</div>
				</div>
			</div>
		</form>
	</article>
</div>
</body>
<script src="<c:url value='/resources/js/user/userLogin.js'/>" charset="utf-8"></script>
<script src="<c:url value='/resources/js/login/kakaoLogin.js'/>" charset="utf-8"></script>


</html>