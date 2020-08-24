<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<script src="<c:url value='/resources/js/common/common.js'/>" charset="utf-8"></script>
<script src="<c:url value='/resources/js/notice/noticeLs.js'/>" charset="utf-8"></script>	
	<h1>스터디 게시판</h1>
	<form name="form" id="form" action="/ynm/notice/serch" method="post">
	 	<div class="input-group">
			 <select name="searchType" id="searchType" class="form-control">
				<option value="title">제목</option>
				<option value="content">본문</option>
				<option value="user">작성자</option>
			</select>
		    <input type="text" name="keyword" id="keyword" placeholder="Search" class="form-control">
		    <button type="submit" id="btnSerch" class="btn btn-default">검색</button>
		 </div>
  	
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
