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
    <script src="<c:url value='/resources/js/board/boardLs.js'/>" charset="utf-8"></script>
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
			 <c:choose>
				<c:when test="${fn:length(comment) > 0}">
					<ul>
					<c:forEach items="${comment}" var="row" varStatus="status">
					
							<li class="titem">
								 <a href="/ynm/board/${row.BOARD_IDX}">
									 ${row.COMMENT}
									 ${row.WRITER}
									 ${row.REG_DATETIME}
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