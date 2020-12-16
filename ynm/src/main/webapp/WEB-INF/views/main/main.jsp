<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!-- main page -->
			<div id="tag">
				<ul>
					<c:forEach var="item" items="${hash}" varStatus="idx">
						<li class="tag" id="${item}">${item}</li>
					</c:forEach>
				</ul>
			</div>
			<div id="comment">
				<h3>최신 댓글 (일단 5개만)</h3>
				<c:choose>
					<c:when test="${fn:length(comment) > 0}">
						<ul>
							<c:forEach items="${comment}" var="row" varStatus="status">
								<li class="titem"><a
									href="<c:url value="/board/${row.BOARD_IDX}"/>"> <img
										src="${row.imgUrl}" style="width: 10px; height: 10px;" />
										${row.comment} ${row.userName} ${row.git}
								</a></li>
							</c:forEach>
						</ul>
					</c:when>
				</c:choose>
			</div>
<!-- main page -->