<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<script src="<c:url value='/resources/js/notice/noticeEd.js'/>" charset="utf-8"></script>
<script src="<c:url value='/resources/js/common/attach.js'/>" charset="utf-8"></script>
<form name="form" id="form" action="/ynm/notice" method="post">
	<input type="hidden" name="searchType" value="${param.searchType}">
	<input type="hidden" name="keyword" value="${param.keyword}">
	<div class="container">
		<table class="table">
			<tr>
				<td colspan="2"><strong>${data.TITLE }</strong></td>
			</tr>
			<tr>
				<td>${data.CREATE_ID }</td>
				<td>${data.CREATE_DATETIME}</td>
			</tr>
			<c:if test="${files[0].FILE_NO ne null}">
			<tr>
				<td colspan="2">
				<c:forEach items="${files}" var="row" varStatus="status">
					<div id="download" data="${row.FILE_NO}">
						<span class="glyphicon glyphicon-download">${row.ORG_FILE_NAME }</span>
					</div>
				</c:forEach>
				</td>
			<tr>
			</c:if>
			<tr>
				<td colspan="2">
					<div>${data.CONTENTS }</div>
				</td>
			</tr>
		</table>
		<div class="form-group button">
			<button type="button" id="modify" data="${data.IDX}" class="btn btn-warning">수정</button>
			<button type="button" id="delete" data="${data.IDX}" class="btn btn-danger">삭제</button>
			<button type="button" id="list" class="btn btn-default">목록</button>
		</div>
	</div>


</form>