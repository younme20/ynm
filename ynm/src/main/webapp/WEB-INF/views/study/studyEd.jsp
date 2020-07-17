<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>first</title>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/ui.css'/>" />
<!--  <link rel="stylesheet" href="libs/bootstrap/css/bootstrap.min.css"> -->
<!-- jQuery 
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script> --> 

<script src="https://code.jquery.com/jquery-3.4.1.min.js" type="text/javascript"></script>
<link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-lite.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-lite.min.js"></script>

<script src="<c:url value='/resources/js/common/common.js'/>" charset="utf-8"></script>
<script src="<c:url value='/resources/js/study/studyEd.js'/>" charset="utf-8"></script>

</head>
<body>
	<h2>스터디 관리 게시판</h2>
	<button id="btnList" type="button" class="btn">목록</button>
	<c:choose>
		<c:when test="${editFlag}">
			<button id="btnSave" type="button" class="btn" newFlag="${newFlag}">저장</button>					
		</c:when>					
		<c:otherwise>
			<button id="btnUpdate" type="button" class="btn">수정</button>
		</c:otherwise>
	</c:choose>				
	<button id="btnDelete" type="button" class="btn">삭제</button>	
	<form id="myForm">
		<input type="hidden" id="newFlag" name="newFlag" value="${newFlag}"/>
		<table class="board_view">
			<colgroup>
				<col width="15%"/>
				<col width="35%"/>
				<col width="15%"/>
				<col width="35%"/>
			</colgroup>
			<caption></caption>
			<tbody>			
				<tr>
					<th scope="row">글 번호</th>
					<td>
						<c:choose>
							<c:when test="${editFlag}">
								${newIdx }					
							</c:when>					
							<c:otherwise>
								${map.IDX }
							</c:otherwise>
						</c:choose>	
						<input type="hidden" id="IDX" name="IDX" value="${editFlag ? newIdx : map.IDX}"/>				
					</td>
					<th scope="row">조회수</th>
					<td>${map.HITCNT eq null ? 0 : map.HITCNT }</td>
				</tr>
				<c:choose>
					<c:when test="${!editFlag}">
				<tr>
					<th scope="row">작성자</th>
					<td>${map.CREATE_ID}</td>
					<th scope="row">작성시간</th>
					<td>${map.CREATE_DATETIME}</td>
				</tr>
					</c:when>
				</c:choose>
				<tr>
					<th scope="row">제목</th>
					<td colspan="3">
						<c:choose>
							<c:when test="${editFlag}">
								<input type="text" id="TITLE" name="TITLE" value="${map.TITLE }" class="wdp_90"></input>							
							</c:when>					
							<c:otherwise>
								${map.TITLE }
							</c:otherwise>
						</c:choose>					
					</td>
				</tr>
				<tr>
					<td colspan="4">
						<c:choose>
							<c:when test="${editFlag}">
								<div id="summernote">${map.CONTENTS }</div>	
							</c:when>					
							<c:otherwise>
								${map.CONTENTS }
							</c:otherwise>
						</c:choose>								
					</td>
				</tr>
			</tbody>
		</table>
	</form>
</body>
</html>