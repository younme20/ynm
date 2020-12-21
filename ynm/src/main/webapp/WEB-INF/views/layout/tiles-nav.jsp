<%@ page import="java.util.Arrays" %>
<%@ page import="com.google.common.net.HttpHeaders" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
    boolean isAuth = false;

    if(request.getCookies() != null){
        for(Cookie cookie : request.getCookies()) {
            if (HttpHeaders.AUTHORIZATION.equals(cookie.getName())) {
                isAuth = true;
            }
        }
        request.setAttribute("isAuth", isAuth);
    }

%>
<!-- nav page -->
<div class="navbar">
 	<c:if test="${isAuth}">
	    <div class="hamburger" id="hamburger-1">
	        <span class="line"></span>
	        <span class="line"></span>
	        <span class="line"></span>
	    </div>
     </c:if>
    <div class="logo">
        <a href="/">StudyLog</a>
    </div>

      <c:choose>
		<c:when test="${isAuth}">
			<div class="btn">
				<button type="button" id="btnWritePlan" class="new-btn">
					<i class="fa fa-calendar-alt"></i><p> 일정쓰기</p>
				</button>
				<button type="button" id="btnWriteFrom" class="new-btn">
					<i class="fa fa-book-reader"></i> <p>글쓰기</p>
				</button>
				<button type="button" id="btnLogout" class="new-btn">
					<i class="fa fa-sign-out-alt"></i> <p>로그아웃</p>
				</button>
			</div>
		</c:when>
		<c:otherwise>
			<div class="btn">
				<button type="button" id="btnShowPlan" class="new-btn">
					<i class="fa fa-calendar-alt"></i> <p>일정보기</p>
				</button>
				<button type="button" id="btnMoveLoginPage" class="new-btn">
					<i class="fa fa-sign-in-alt"></i> <p>로그인</p>
				</button>
			</div>
		</c:otherwise>
	</c:choose>
            
            
</div>



<div class="modal fade" id="navPlanModal" role="dialog" aria-labelledby="navPlanModalLabel">
    <div class="modal-dialog modal-sm" role="document" style="max-width: 50%; max-height: 50%; width: auto; height: auto; display: table;" tabindex="-1">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">×</span></button>
                <h4 class="modal-title" id="navPlanModalLabel">이번 주의 일정</h4>
            </div>
            <c:if test="${!isAuth}">
                <div id="calendar" type="date"></div>
            </c:if>
        </div>
    </div>
</div>

<!-- nav page -->