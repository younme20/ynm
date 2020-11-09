<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html lang="en">
<body>
<div id="wrapper" style="margin-top: 20px;">
    <div class="col-sm-12" style="text-align: center;">
        <!-- 태그 -->
        <p style="margin-bottom: 5%">
            <c:forEach items="${categories}" var="tag" varStatus="status">
            	${tag.key} (${tag.value})		
            </c:forEach>
        </p>
        <h1 style="margin-bottom: 5%"><strong>${data.TITLE }</strong></h1>

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
        <div>
            ${data.CONTENTS }
        </div>
		<div id="tlist">
			<ul>
				<c:forEach var="item" items="${hash}" varStatus="idx">
					<li class="titem"><p>${item}</p></li>
				</c:forEach>
			</ul>
		</div>
		<div class="form-group button">
			<button type="button" id="modify" data="${data.IDX}" class="btn btn-warning">수정</button>
			<button type="button" id="delete" data="${data.IDX}" class="btn btn-danger">삭제</button>
			<button type="button" id="list" class="btn">목록</button>
		</div>

</div>
</div></body>
<link href="<c:url value='/resources/css/board.css'/>" rel="stylesheet">
<link href="<c:url value="/resources/css/hashtag.css" />" rel="stylesheet">
<script src="<c:url value='/resources/js/common/common.js'/>" charset="utf-8"></script>
<script src="<c:url value='/resources/js/board/boardVw.js'/>" charset="utf-8"></script>
</html>