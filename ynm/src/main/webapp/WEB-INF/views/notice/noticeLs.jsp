<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

	<h1>스터디 게시판</h1>
	<form id="form" method="post">
	<div class="table-responsive">
	<table  class="table">
	    <colgroup>
	        <col width="10%"/><col width="*"/><col width="15%"/><col width="20%"/><col width="15%"/>
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
	</div>
	</form>
	<button type="button" id="write" class="btn btn-primary">글쓰기</button>  
