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
<!-- TODO: 헤더 공통으로 빼기 -->
<section id="main">
	<header>
		<span class="avatar"><img src="<c:url value='/resources/images/avatar.jpg' />" alt=""></span>
		<h3>${username} 님 환영합니다!!</h3>

		<h9><a href="/ynm/schedule">plan</a>  *  <a href="/ynm/study">categories</a> *  <a>search</a></h9>
	</header>
</section>
</body>
<body2>
<div id="wrapper" style="margin-top: 20px;">
		<div class="col-sm-12" style="text-align: center;">
			<!-- 태그 -->
			<p style="margin-bottom: 3%">
				<c:forEach items="${categories}" var="tag" varStatus="status">${tag.key} (${tag.value})		</c:forEach>
			</p>
			<c:choose>
				<c:when test="${fn:length(list) > 0}">
					<c:forEach items="${list}" var="row" varStatus="status">
						<input type="hidden" id="idx_${status.count}" name="idx" value="${row.IDX}"></input>
								<p style="border-bottom: solid 1px gray; margin: auto auto 3%;width: 50%">
									<a href="#this" name="title" idx="${row.IDX}" cnt="${(fn:length(list)+1) - status.count}" >
										<h1><b>${row.TITLE}</b></h1>
										</a>
										${row.CREATE_DATETIME }
								</p>
						</tr>
					</c:forEach>
				</c:when>
				<c:otherwise>
					<tr>
						<td colspan="4">조회된 결과가 없습니다.</td>
					</tr>
				</c:otherwise>
			</c:choose>
		</div>
		<c:set var="listIndex" value="${totalCount / page.pageSize}" />
		<c:forEach var="i" begin="1" end="${(listIndex mod 2) eq 1 ? listIndex : listIndex+1}">
			<p style="float: left; margin-left: 5px; margin-bottom: 20px;"><a href="#this" id="index_${i}" pageidx="${param.pageIndex}" name="index">${i}</a></p>
		</c:forEach>
</div>
</body2>
<script src="<c:url value='/resources/js/common/common.js'/>" charset="utf-8"></script>
<script src="<c:url value='/resources/js/study/studyLs.js'/>" charset="utf-8"></script>
</html>