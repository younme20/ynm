<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!-- login page -->
<div class="loginfm">
	<h2>Right now!</h2>
		<form class="form-signin" method="post" id="myForm">
			<input type="hidden"  name="${_csrf.parameterName}"   value="${_csrf.token}">
			<div class="form-group">
				<div class="col">
					<input type="text" id="username" name="username" class="form-control" placeholder="Usernameeeee" required="" autofocus="">
				</div>
			</div>
			<div class="form-group">
				<div class="col">
					<input type="password" id="password" name="password" class="form-control" placeholder="Passworddddd" required="">
				</div>
			</div>
			<div class="form-group">
				<div class="col">
					<div class="btn-icon">
						<button type="button" id="join" data="${data.IDX}" class="btn-li new-btn"><i class="fa fa-sign-language"></i>회원가입</button>
						<button type="button" id="btnLogin" data="${data.IDX}" class="btn-li new-btn"><i class="fa fa-sign-in-alt"></i>로그인</button>
					</div>
				</div>
			</div>
		</form>
</div>
	
<!-- login page -->