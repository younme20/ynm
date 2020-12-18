<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<h2>간단한 회원가입</h2>
	<form class="form-signin" method="post" id="myForm">
		<input type="hidden" name="role" id="role" value="USER" >
		<input type="text" name="username" id="username" data-name="아이디" placeholder="아이디를 입력하세요" class="form-control">
		<input type="password" name="password" id="password" data-name="비밀번호" placeholder="비밀번호를 입력하세요" class="form-control">
		
		<button type="button" class="btn btn-lg btn-primary btn-block" id="btnJoin" class="form-control">join</button>
	</form>
<script src="<c:url value='/resources/js/user/userJoin.js'/>" charset="utf-8"></script>
