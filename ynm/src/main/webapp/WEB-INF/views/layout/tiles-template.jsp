<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title></title>
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