<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>

<!-- nav page -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>

<!-- 일정관리 모달(단순 조회용) -->
<jsp:include page="../schedule/scheduleNavModal.jsp"></jsp:include>

<header class="header">
    <div class="main">
        STUDY_LOG
    </div>
    <div class="main-btn">
        <div class="btn-icon btn-right">
            <!-- <button type="button" id="btnMyPage" class=""><i class="fa fa-book-reader"></i> 마이페이지 </button> -->
            <button type="button" id="btnShowPlan" class="new-btn"><i class="fa fa-calendar-alt"></i> 일정보기 </button>
            <c:choose>
                <c:when test="${username != null}">
                    <button type="button" id="btnLogout" class="new-btn"><i class="fa fa-sign-out-alt"></i> 로그아웃 </button>
                </c:when>
                <c:otherwise>
                    <button type="button" id="btnMoveLoginPage" class="new-btn"><i class="fa fa-sing-in-alt"></i> 로그인 </button>
                </c:otherwise>
            </c:choose>

        </div>
    </div>
    <div class="pt-5"></div>
    <c:forEach items="${list}" var="item">
        <c:choose>
            <c:when test="${item.PARENT_IDX != null}">
                <ul>
                    <li id="item_${item.PARENT_IDX}" class="item">
                        <a href="/ynm/board/${item.IDX}">${item.TITLE}</a>
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
<aside class="aside">

</aside>

