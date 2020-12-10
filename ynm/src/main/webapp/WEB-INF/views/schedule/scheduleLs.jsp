<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html lang="en">
<jsp:include page="../common/scheduleModal.jsp"></jsp:include>
<!-- 일정관리 모달 -->
<body>
    <div class="container">
        <div id="wrapper">
<%--            <details>--%>
<%--                <summary>오늘의 할 일 보기</summary>--%>
<%--                <br>--%>
<%--                <div class="col-sm-12">--%>
<%--                    <div class="row">--%>
<%--                        <c:forEach var="i" begin="0" end="1">--%>
<%--                            <div id="selection_${i}" style="border: 0.05em solid #808080; margin-right: 25px; margin-bottom: 25px; width: 20em; height: 15em;">--%>
<%--                                test--%>
<%--                            </div>--%>
<%--                        </c:forEach>--%>
<%--                    </div>--%>
<%--                </div>--%>
<%--            </details>--%>
            <div id="calendar"  style="width:50%"></div>
        </div>
    </div>
</body>
</html>