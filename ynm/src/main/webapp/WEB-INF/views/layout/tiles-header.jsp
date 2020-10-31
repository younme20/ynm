<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<!DOCTYPE html>
<html>
<head>
	<script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-lite.min.js"></script>

	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

	<link href="<c:url value='/resources/css/main.css' />" rel="stylesheet">
	<section id="main">
		<header>
			<span class="avatar"><img src="<c:url value='/resources/images/avatar.jpg' />" alt=""></span>
			<h3>${username} 님 환영합니다!!</h3>

			<h9><a href="/ynm/schedule">plan</a>  *  <a href="/ynm/board">categories</a> *  <a>search</a></h9>
		</header>
	</section>

	<!-- 일정관리 모달 -->
	<jsp:include page="../common/scheduleModal.jsp"></jsp:include>
    	
	<title></title>
</head>
<body>

	 	
</body>
</html>
<!-- header page -->	
