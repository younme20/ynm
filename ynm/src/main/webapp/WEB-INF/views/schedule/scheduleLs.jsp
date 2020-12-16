<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html lang="en">
<jsp:include page="../common/scheduleModal.jsp"></jsp:include>
<!-- 일정관리 모달 -->
<body>
    <div class="main-wrapper">
        <div id="calendar" type="date" style="width:50%"></div>
        <div class="new-btn-group">
            <button type="button" id="btnWritePlanModal" class="new-btn">일정 추가</button>
        </div>
    </div>
</body>
</html>