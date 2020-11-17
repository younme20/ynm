<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html lang="en">
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<meta name="description" content="">
	<meta name="author" content="">
	<meta name = "google-signin-scope" content = "profile email" >
	<meta name="google-signin-client_id" content="qmd6rs2k1a8mtpem3e7l7894jvvm3lu9.apps.googleusercontent.com">
	<meta name="google-site-verification" content="6Wv-TUkJEASHwI2CCANMB0gDcpzqd6ImpMtE_AEHlvY" />
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
		<h2>Right now!</h2>
		<form class="form-signin" method="post" id="myForm">
			<input type="hidden"  name="${_csrf.parameterName}"   value="${_csrf.token}"/>
			<p>
				<label for="username" class="sr-only">Username</label>
				<input type="text" id="username" name="username" class="form-control" placeholder="Usernameeeee" required="" autofocus="">
			</p>
			<p>
				<label for="password" class="sr-only">Password</label>
				<input type="password" id="password" name="password" class="form-control" placeholder="Passworddddd" required="">
			</p>
			<p><a href="javascript:alert('api 로그인 추가하기!');"><h6 style="font-size: 10px;">간단하게 가입하실래요?</h6></a></p>
			<button type="button" class="btn btn-lg btn-primary btn-block" id="btnLogin">login</button>
			<div id="loginGrp">
				
				<!-- GOOGLE LOGIN API -->
				<div class="g-signin2" data-onsuccess="onSignIn"></div>
				<!-- GOOGLE LOGIN API -->	
				
				

			</div>
			
				<!-- KAKAO LOGIN API -->
				<a id="custom-login-btn" href="javascript:loginWithKakao()">
				  <img
				    src="//k.kakaocdn.net/14/dn/btqCn0WEmI3/nijroPfbpCa4at5EIsjyf0/o.jpg"
				    width="222"
				  />
				</a>
				
				<div>카카오 아이디 : <span id="kakaoIdentity"></span></div>

			    <div>닉네임 : <span id="kakaoNickName"></span></div>
			
			    <div>프로필 이미지 : <img id="kakaoProfileImg" src=""/></div>
			
			    <div>썸네일 이미지 : <img id="kakaoThumbnailImg" src=""/></div>
				<!-- KAKAO LOGIN API -->
		</form>
		
<script src="https://developers.kakao.com/sdk/js/kakao.min.js" ></script>
	<script type="text/javascript">
	
     /*  function onSignIn(googleUser) {
        // Useful data for your client-side scripts:
        var profile = googleUser.getBasicProfile();
        console.log("ID: " + profile.getId()); // Don't send this directly to your server!
        console.log('Full Name: ' + profile.getName());
        console.log('Given Name: ' + profile.getGivenName());
        console.log('Family Name: ' + profile.getFamilyName());
        console.log("Image URL: " + profile.getImageUrl());
        console.log("Email: " + profile.getEmail());

        // The ID token you need to pass to your backend:
        var id_token = googleUser.getAuthResponse().id_token;
        console.log("ID Token: " + id_token);
      } */
      
      //<![CDATA[
      // 사용할 앱의 JavaScript 키를 설정해 주세요.
      Kakao.init("cbd240304d9fcadf483fd88889853541");
      
      function loginWithKakao() {
	    Kakao.Auth.login({
	    	 container: '#CONTAINER_ID',
	    	  success: function(response) {
	    	    console.log(response);
	    	  },
	    	  fail: function(error) {
	    	    console.log(error);
	    	  },
	    })
	  }
    </script>
</body>
<script src="<c:url value='/resources/js/common/common.js'/>" charset="utf-8"></script>
<script src="<c:url value='/resources/js/user/userLogin.js'/>" charset="utf-8"></script>
<script src="https://apis.google.com/js/platform.js" async defer></script>
</html>