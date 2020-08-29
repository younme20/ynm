<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<link href="<c:url value="/resources/css/notice.css" />" rel="stylesheet">
<script src="<c:url value='/resources/js/common/common.js'/>" charset="utf-8"></script>
<script src="<c:url value='/resources/js/notice/noticeLs.js'/>" charset="utf-8"></script>	
	<div class="con">
	<h1>스터디 게시판</h1>
	
	
	<form name="form" id="form" action="/ynm/notice/serch" method="post">
	 	<div class="serch-group">
			 <select name="searchType" id="searchType" class="form-control">
				<option value="title">제목</option>
				<option value="content">본문</option>
				<option value="user">작성자</option>
			</select>
		    <input type="text" name="keyword" id="keyword" placeholder="Search" class="form-control">
		    <button type="submit" id="btnSerch" class="btn">검색</button>
		 </div>
		<div class="table-responsive">
			<table  class="table">
			    <colgroup>
			        <col width="10%"/><col width="*"/><col width="15%"/><col width="20%"/><col width="15%"/>
			    </colgroup>
			    <thead>
			        <tr>
			            <th scope="col">no</th>
			            <th scope="col">제목</th>
			            <th scope="col">작성자</th>
			            <th scope="col">작성일</th>
			            <th scope="col">조회수</th>
			        </tr>
			    </thead>
			    <tbody>
			        <c:choose>
			            <c:when test="${fn:length(list) > 0}">
			             <c:set var="num" value="${totalCount - ((page.pageIndex-1) * page.pageSize) }"/>
			                <c:forEach items="${list}" var="row">
			               
			                    <tr>
			                        <td>${num}</td>
			                        <td>
			                        	<a href="<c:url value='/notice/detail/${row.IDX}'/>">
											${row.TITLE }
			                        	</a>
			                        </td>
			                        <td>${row.CREATE_ID }</td>
			                        <td>${row.CREATE_DATETIME }</td>
			                        <td>${row.HITCNT }</td>
			                    </tr>
			                     <c:set var="num" value="${num-1 }" />
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
			<button type="button" id="write" class="btn btn-default">글쓰기</button>  
		</div>
		
		
			 
			<div id="paging" >
				<c:set var="listIndex" value="${totalCount / page.pageSize}" />
				<c:set var="lastIndex" value="${(totalCount mod page.pageSize) == 0 ? listIndex : listIndex+1}" />
				<c:set var="endIndex" value="${lastIndex-(lastIndex%1)}" />
				<ul  class="pagination">
					<c:if test="${page.pageIndex > 1 }">
						<li><a href="javascript:;" onClick="pageMove(this);"  pageidx="${page.pageIndex-1}">&lt;</a></li>
					</c:if>
					<c:forEach var="i" begin="1" end="${endIndex}">
						<c:choose>
							<c:when test="${i == page.pageIndex }">
								<li class="active"><a href="javascript:;" onClick="pageMove(this);" id="index_${i}" pageidx="${i}" name="index">${i}</a></li>
							</c:when>
							<c:when test="${i != page.pageIndex }">
								<li><a href="javascript:;" onClick="pageMove(this);" id="index_${i}" pageidx="${i}" name="index">${i}</a></li>
							</c:when>
						</c:choose>
					</c:forEach>
					<c:if test="${page.pageIndex != endIndex}">
						<li><a href="javascript:;" onClick="pageMove(this);" pageidx="${page.pageIndex+1}">&gt;</a></li>
					</c:if>
				</ul>
			</div>
		</form>
	</div>