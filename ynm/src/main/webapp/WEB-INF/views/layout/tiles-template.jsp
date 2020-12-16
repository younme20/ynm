<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
	<tiles:insertAttribute name="header" />
</head>
<body>
	<tiles:insertAttribute name="nav" />
    <tiles:insertAttribute name="left" />
    <div class="container">
	    <div class="main">
			<div class="main-content">
	    		<tiles:insertAttribute name="content" />
	    	</div>
		</div>
    </div>
    <tiles:insertAttribute name="footer" />
</body>
</html>