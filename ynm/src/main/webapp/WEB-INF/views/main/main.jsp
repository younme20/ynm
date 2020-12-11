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
						<li class="titem"><p>${item}</p></li>
					</c:forEach>
				</ul>
			</div>
			<div id="comment">
			 <c:choose>
				<c:when test="${fn:length(comment) > 0}">
					<c:forEach items="${comment}" var="row" varStatus="status">
						<ul>
							<li class="titem">
								<input type="hidden" id="idx_${status.count}" name="idx" value="${row.board_idx}">
								<p
									style="border-bottom: solid 1px gray; margin: auto auto 3%; width: 50%">
									<a href="#this" name="title" idx="${row.board_idx}"
										cnt="${(fn:length(comment)+1) - status.count}">
										
											<b>${row.cmment}</b>
											<span>${row.writer}</span>
									</a>
									${row.reg_datetime }
								</p>
							</li>
						</ul>
					</c:forEach>
				</c:when>
			</c:choose>
			</div>
		</div>
	</div>
</body>
</html>