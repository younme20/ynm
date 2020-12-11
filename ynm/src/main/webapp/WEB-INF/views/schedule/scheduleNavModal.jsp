<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<head>
    <script src="<c:url value='/resources/js/common/schedule.js'/>" charset="utf-8"></script>
    <title></title>
</head>
<body>
<div class="modal fade" id="navPlanModal" role="dialog" aria-labelledby="navPlanModalLabel">
    <div class="modal-dialog modal-sm" role="document" style="max-width: 50%; max-height: 50%; width: auto; height: auto; display: table;" tabindex="-1">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">×</span></button>
                <h4 class="modal-title" id="navPlanModalLabel">이번 주의 일정</h4>
            </div>
            <div id="calendar"></div>
        </div>
    </div>
</div>
</body>
</html>