<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title></title>
	<script src="https://code.jquery.com/jquery-3.4.1.min.js" type="text/javascript"></script>
	<script src="<c:url value='/resources/js/common/common.js'/>"charset="utf-8"></script>
	<script src="<c:url value='/resources/js/notice/noticeEd.js'/>"charset="utf-8"></script>
	<script src="<c:url value='/resources/js/notice/noticeLs.js'/>" charset="utf-8"></script>
	<script src="<c:url value='/resources/js/common/jquery.serializeObject.min.js'/>"charset="utf-8"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
</head>
<body>
    <tiles:insertAttribute name="header" />
    <tiles:insertAttribute name="nav" />
    <tiles:insertAttribute name="left" />
    <div id="container">
       <tiles:insertAttribute name="content" />
    </div>
    <tiles:insertAttribute name="footer" />
</body>
</html>