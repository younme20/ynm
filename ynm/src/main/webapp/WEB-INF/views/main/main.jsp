<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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
						<li class="tag" id="${item}">${item}</li>
					</c:forEach>
				</ul>
			</div>
			<div id="comment">
				<h3>최신 댓글 (일단 5개만)</h3>
			 <c:choose>
				<c:when test="${fn:length(comment) > 0}">
					<ul>
					<c:forEach items="${comment}" var="row" varStatus="status">
							<li class="titem">
								 <a href="<c:url value="/board/${row.BOARD_IDX}"/>">
									 <img src="${row.imgUrl}" style="width:10px;height:10px;" />
									 ${row.comment}
									 ${row.userName}
									 ${row.git}
								 </a>
							</li>
					</c:forEach>
					</ul>
				</c:when>
			</c:choose>
			</div>
		</div>
	</div>
</body>
</html>