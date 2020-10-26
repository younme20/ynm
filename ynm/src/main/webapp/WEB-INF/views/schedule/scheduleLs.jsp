<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>Main Page</title>
    <link href="<c:url value='/resources/css/main.css' />" rel="stylesheet">
</head>
<body class="none">
<section id="main">
    <header>
        <span class="avatar"><img src="<c:url value='/resources/images/avatar.jpg' />" alt=""></span>
        <h3>${username} 님 환영합니다!!</h3>

        <h9>plan * categories * search</h9>
    </header>
</section>
</body>
<body2>
    <div class="wrapper" style="margin-top: 20px;">
        <div class="col-sm-12" style="text-align: center;">
            <div id="calendar" style="width: 70%"></div>
        </div>
    </div>
</body2>
<script src="<c:url value='/resources/js/common/common.js'/>" charset="utf-8"></script>
</html>