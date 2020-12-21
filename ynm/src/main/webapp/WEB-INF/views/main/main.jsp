<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!-- main page -->

			<div id="tag" class="pt-5">
				<h3 class="pt-5 ml-5 mb-3">해시 태그</h3>
				<ul>
					<c:forEach var="item" items="${hash}" varStatus="idx">
						<li class="tag" id="${item}">${item}</li>
					</c:forEach>
				</ul>
			</div>
			<div id="comment">
				<h3 class="pt-5 ml-5 mb-3">최신 댓글</h3>
			 <c:choose>
				<c:when test="${fn:length(comment) > 0}">
					<ul>
					<c:forEach items="${comment}" var="row" varStatus="status">
							<li class="titem">
								 <a href="<c:url value="${row.idx}"/>">
									 <img src="${row.imgUrl}" style="width:30px;height:30px;" />
									 ${row.comment}
								 </a>
								by ${row.userName}
								${row.git}
							</li>
					</c:forEach>
					</ul>
				</c:when>
			</c:choose>
			</div>
<!-- main page -->