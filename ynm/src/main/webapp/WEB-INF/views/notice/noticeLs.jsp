<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.4.1.min.js" type="text/javascript"></script>
<script src="<c:url value='/resources/js/common/common.js'/>"charset="utf-8"></script>
<script src="<c:url value='/resources/js/notice/noticeLs.js'/>"charset="utf-8"></script>
</head>
<body>
	공지사항 게시판 목록
	<form id="form" method="post">
	<table style="border:1px solid #ccc">
	    <colgroup>
	        <col width="10%"/>
	        <col width="*"/>
	        <col width="15%"/>
	        <col width="20%"/>
	        <col width="15%"/>
	    </colgroup>
	    <thead>
	        <tr>
	            <th scope="col">글번호</th>
	            <th scope="col">제목</th>
	            <th scope="col">작성자</th>
	            <th scope="col">작성일</th>
	            <th scope="col">조회수</th>
	        </tr>
	    </thead>
	    <tbody>
	        <c:choose>
	            <c:when test="${fn:length(list) > 0}">
	                <c:forEach items="${list}" var="row">
	                    <tr>
	                        <td>${row.IDX }</td>
	                        <td>
	                        	<a href="<c:url value='/notice/detail/${row.IDX}'/>">
									${row.TITLE }
	                        	</a>
	                        </td>
	                        <td>${row.CREATE_ID }</td>
	                        <td>${row.CREATE_DATETIME }</td>
	                        <td>${row.HITCNT }</td>
	                    </tr>
	                </c:forEach>
	            </c:when>
	            <c:otherwise>
	                <tr>
	                    <td colspan="5">조회된 결과가 없습니다.</td>
	                </tr>
	            </c:otherwise>
	        </c:choose>
	          
	    </tbody>
	</table>
	</form>
	<button type="button" id="write">글쓰기</button>  
</body>
</html>