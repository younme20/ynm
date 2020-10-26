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
        <h1>Beam Us UP</h1>
        <h3>${username} 님 환영합니다!!</h3>

        <h3>*</h3>
        <h3>*</h3>
        <h3>*</h3>

        <h2><a class="hover" href="/ynm/schedule">Monthly Plan</a></h2>
        <h2><a class="hover" href="/ynm/study">Categories</a></h2>
        <h2><a class="hover">Search</a></h2>

    <p>Project management</p>
    </header>
    <hr>
</section>
</body>
<script src="<c:url value='/resources/js/common/common.js'/>" charset="utf-8"></script>
</html>