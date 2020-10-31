<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html lang="en">
<!-- full canlander -->
<link href='/ynm/resources/static/fullcalendar/lib/main.css' rel='stylesheet' />
<script src='/ynm/resources/static/fullcalendar/lib/main.js'></script>
<body>
    <div class="container">
        <div id="wrapper">
            <div id="loading"></div>
            <div id="calendar"></div>
        </div>
    </div>
</body>
<script src="<c:url value='/resources/js/common/common.js'/>" charset="utf-8"></script>
</html>