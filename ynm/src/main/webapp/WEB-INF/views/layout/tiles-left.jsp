<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Insert title here</title>
</head>
<body>
<!-- left page -->
		<div id="wrapper">
			<ul class="nav nav-tabs">
				<li><a href="/ynm">M</a></li>
				<li><a href="/ynm/menu/study">G</a></li>
				<li><a href="/ynm/menu/notice">B</a></li>
				<li><a href="${auth ? "/ynm/logout" : "/ynm/login"}">${auth ? "LOGOUT" : "LOGIN"}</a></li>
			</ul>
		</div>
<!-- left page -->
</body>
</html>


