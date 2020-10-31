<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html lang="en">
<body>
<div id="wrapper" style="margin-top: 20px;">
    <div class="col-sm-12" style="text-align: center;">
        <!-- 태그 -->
        <p style="margin-bottom: 5%">
            <c:forEach items="${categories}" var="tag" varStatus="status">${tag.key} (${tag.value})		</c:forEach>
        </p>
        <h1 style="margin-bottom: 5%"><strong>${data.TITLE }</strong></h1>

        <c:if test="${files[0].FILE_NO ne null}">
        <tr>
            <td colspan="2">
                <c:forEach items="${files}" var="row" varStatus="status">
                    <div class="download"  data="${row.FILE_NO}">
                        <p><span class="glyphicon glyphicon-download"></span>${row.ORG_FILE_NAME}</p>
                    </div>
                </c:forEach>
            </td>
        <tr>
        </c:if>
        <tr>
            ${data.CONTENTS }
        </tr>


</div>
</div></body>
<script src="<c:url value='/resources/js/common/common.js'/>" charset="utf-8"></script>
<script src="<c:url value='/resources/js/notice/noticeEd.js'/>" charset="utf-8"></script>
</html>