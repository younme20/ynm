<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<!DOCTYPE html>
<html>
<head>
	<link href='/ynm/resources/static/fullcalendar/lib/main.css' rel='stylesheet' />
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous"/>
	<!-- <link href='https://cdn.jsdelivr.net/npm/@fortawesome/fontawesome-free@4.7.0/css/all.css' rel='stylesheet'/> -->
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/tempusdominus-bootstrap-4/5.1.2/css/tempusdominus-bootstrap-4.min.css" integrity="sha512-PMjWzHVtwxdq7m7GIxBot5vdxUY+5aKP9wpKtvnNBZrVv1srI8tU6xvFMzG8crLNcMj/8Xl/WWmo/oAP/40p1g==" crossorigin="anonymous" />
	<link href="<c:url value='/resources/css/main.css' />" rel="stylesheet"/>
	<link href="<c:url value='/resources/css/board.css'/>" rel="stylesheet">
	<link href="<c:url value="/resources/css/hashtag.css" />" rel="stylesheet">

	<script src="https://code.jquery.com/jquery-3.4.1.min.js" type="text/javascript"></script>
	
	
	<link href="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.8/summernote-lite.css" rel="stylesheet">
	<script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-lite.min.js"></script>
	
	
	<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.22.2/moment.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/tempusdominus-bootstrap-4/5.1.2/js/tempusdominus-bootstrap-4.min.js" integrity="sha512-2JBCbWoMJPH+Uj7Wq5OLub8E5edWHlTM4ar/YJkZh3plwB2INhhOC3eDoqHm1Za/ZOSksrLlURLoyXVdfQXqwg==" crossorigin="anonymous"></script>
	<script src="<c:url value='/resources/js/common/jquery.serializeObject.min.js'/>"charset="utf-8"></script>

	
	
	<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
	<script src='/ynm/resources/static/fullcalendar/lib/main.js'></script>

	<!-- 공통js -->
	<script src="<c:url value='/resources/js/common/common.js'/>"charset="utf-8"></script>
	
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<div style="margin-left: 95%;"><a href="/ynm/out">로그아웃</a></div>
	<section id="main">
		<header>
			<span class="avatar"><img src="<c:url value='/resources/images/avatar.jpg' />" alt=""></span>
			<h3>${username} 님 환영합니다!!</h3>

			<h6 style="font-size: 10px"><a href="/ynm/schedule">calendar</a>  *  <a href="/ynm/board">categories</a> *  <a>search</a></h6>
		</header>
	</section>

	<title></title>
</head>
<body>
</body>
</html>
<!-- header page -->	
