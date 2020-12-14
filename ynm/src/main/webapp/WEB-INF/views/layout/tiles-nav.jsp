<%@ page import="java.util.Arrays" %>
<%@ page import="com.google.common.net.HttpHeaders" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>

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

<header class="header">
    <div class="main">
        <a href="<c:url value='/'/>" style="cursor: pointer; text-decoration: none;">STUDY_LOG</a>
    </div>
    <div class="main-btn">
        <div class="btn-icon btn-right">
            <c:choose>
                <c:when test="${isAuth}">
                    <button type="button" id="btnWritePlan" class="new-btn"><i class="fa fa-calendar-alt"></i> 일정쓰기</button>
                    <button type="button" id="btnLogout" class="new-btn"><i class="fa fa-sign-out-alt"></i> 로그아웃 </button>
               		<button type="button" id="btnWriteFrom" class="new-btn"><i class="fa fa-book-reader"></i> 글쓰기 </button>
                </c:when>
                <c:otherwise>
                    <button type="button" id="btnShowPlan" class="new-btn"><i class="fa fa-calendar-alt"></i> 일정보기</button>
                    <button type="button" id="btnMoveLoginPage" class="new-btn"><i class="fa fa-sign-in-alt"></i> 로그인 </button>
                </c:otherwise>
            </c:choose>
        </div>
    </div>
    <div class="pt-5"></div>
    <c:forEach items="${list}" var="item">
        <c:choose>
            <c:when test="${item.PARENT_IDX != null}">
                <ul>
                    <li group="${item.PARENT_IDX}" class="item">
                        <a href="<c:url value='/board/${item.IDX}'/>">${item.TITLE}</a>
                    </li>
                </ul>
            </c:when>
            <c:otherwise>
                <ul>
                    <li>
                        <a href="#" class="">${item.TITLE}
                            <button id="btn_${item.IDX}" aria-label="collapse" class="collapser" onclick="sideBarClick(${item.IDX})">
                                <i class="fa fa-plus"></i>
                            </button>
                        </a>
                    </li>
                </ul>
            </c:otherwise>
        </c:choose>
    </c:forEach>
</header>
<%--<aside class="aside">--%>
<%--</aside>--%>


<script src="<c:url value='/resources/js/board/boardLs.js'/>" charset="utf-8"></script>
<script src="<c:url value='/resources/js/user/userLogin.js'/>" charset="utf-8"></script>