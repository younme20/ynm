<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE>
<html lang="en">
<body>
    <div id="wrapper" style="margin-top: 20px;">
        <div class="col-sm-12" style="text-align: center;">
            <!-- 태그 -->
            <p style="margin-bottom: 3%">
                <c:forEach items="${categories}" var="tag" varStatus="status">${tag.key} (${tag.value})		</c:forEach>
            </p>
            <a id="writeFrom">글쓰기</a>
            <!-- 보드 리스트 -->
            <c:choose>
                <c:when test="${fn:length(list) > 0}">
                    <c:forEach items="${list}" var="row" varStatus="status">
                    	<tr>
	                        <input type="hidden" id="idx_${status.count}" name="idx" value="${row.IDX}">
	                        <p style="border-bottom: solid 1px gray; margin: auto auto 3%;width: 50%">
	                            <a href="#this" name="title" idx="${row.IDX}" cnt="${(fn:length(list)+1) - status.count}" >
	                                <h1><b>${row.TITLE}</b></h1>
	                            </a>
	                                ${row.CREATE_DATETIME }
	                        </p>
                        </tr>
                    </c:forEach>
                </c:when>
                <c:otherwise>
                    <tr>
                        <td colspan="4">조회된 결과가 없습니다.</td>
                    </tr>
                </c:otherwise>
            </c:choose>
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
					<c:if test="${page.pageIndex < endIndex}">
						<li><a href="javascript:;" onClick="pageMove(this);" pageidx="${page.pageIndex+1}">&gt;</a></li>
					</c:if>
				</ul>
			</div>
            <!-- TODO: lazy loading 적용 -->
        </div>
    </div>
</body>
<script src="<c:url value='/resources/js/common/common.js'/>" charset="utf-8"></script>
<script src="<c:url value='/resources/js/board/boardLs.js'/>" charset="utf-8"></script>
</html>