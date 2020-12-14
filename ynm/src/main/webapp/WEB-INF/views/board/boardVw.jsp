<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<meta property="og:title" content="${data.TITLE}"/>
<html lang="en">
<head>
<title>${data.TITLE}</title>
</head>
<body>
	<div class="main-wrapper">
		<section class="section py-5">
			<div class="container">
				<h2 class="heading text-center mb-2"><strong>${data.TITLE }</strong></h2>
				<div class="meta">
					<span class="user">written by ${data.CREATE_ID}</span>
					<span class="hitcnt">${data.HITCNT} min read</span>
					${data.CREATE_DATETIME}
				</div>
			</div>
		</section>
		<c:if test="${files[0].FILE_NO ne null}">
		<tr>
			<td colspan="2">
				<div id="fileList">
					<c:forEach items="${files}" var="row" varStatus="status">
						<div class="download"  data="${row.FILE_NO}">
							<span class="glyphicon glyphicon-download">${row.ORG_FILE_NAME}</span>
						</div>
					</c:forEach>
				</div>
			</td>
		<tr>
		</c:if>
		<article class="post px-3 py-5 p-md-5">
			<div class="container body">
				${data.CONTENTS }
			</div>
		</article>

		<div id="tlist">
			<ul>
				<c:forEach var="item" items="${hash}" varStatus="idx">
					<li class="titem"><p>${item}</p></li>
				</c:forEach>
			</ul>
		</div>
		<input type="hidden" id="PARENT_IDX" VALUE="${data.PARENT_IDX}"/>
		<c:if test="${isAuth}">
			<div class="new-btn-group btn-right mt-5 md-5">
				<button type="button" id="modify" data="${data.IDX}" class="btn-li new-btn">수정</button>
				<button type="button" id="delete" data="${data.IDX}" class="btn-li new-btn">삭제</button>
	<%--			<button type="button" id="list" class="btn-li">목록</button>--%>
			</div>
		</c:if>
		<section class="comment-section py-5">
			<div class="mt-5 pt-5">
				<h3 class="heading"><strong>Comments</strong></h3>
				<script src="https://utteranc.es/client.js"
						repo="younme20/ynm"
						issue-term="pathname"
						label="comments"
						theme="boxy-light"
						crossorigin="anonymous"
						async>
				</script>
			</div>
		</section>
	</div>

</body>
<script src="<c:url value='/resources/js/board/boardVw.js'/>" charset="utf-8"></script>
</html>