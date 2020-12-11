<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
</head>
<body>
	<div id="container">
		<div id="content">
			<div id="tag">
				<ul>
					<c:forEach var="item" items="${hash}" varStatus="idx">
						<li class="titem"><p>${item}</p></li>
					</c:forEach>
				</ul>
			</div>
			<div id="comment"></div>
		</div>
	</div>
</body>
</html>