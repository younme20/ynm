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
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<!-- left page -->
<script src="<c:url value='/resources/js/common/schedule.js'/>" charset="utf-8"></script>

<%-- <div class="modal fade" id="navPlanModal" role="dialog" aria-labelledby="navPlanModalLabel">
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
</div> --%>

    
    <div class="left">
	    <c:forEach items="${list}" var="item">
	    	<div>
           <c:choose>
            <c:when test="${item.PARENT_IDX != null}">
                <ul>
                    <li group="${item.PARENT_IDX}" class="item">
                        <a href="<c:url value='/board/${item.IDX}'/>">${item.TITLE}</a>
                    </li>
                </ul>
            </c:when>
            <c:otherwise>
	                 <div class="mtitle">
                        <a href="#" class="">${item.TITLE}
                           <button id="btn_${item.IDX}" aria-label="collapse" class="collapser" onclick="sideBarClick(${item.IDX})">
                               <i class="fa fa-plus"></i>
                           </button>
                       	</a>
	                 </div>
            </c:otherwise>
           </c:choose>
	      
          </div>
	   	</c:forEach>
    </div>
    
<script src="<c:url value='/resources/js/board/boardLs.js'/>" charset="utf-8"></script>
<script src="<c:url value='/resources/js/user/userLogin.js'/>" charset="utf-8"></script>
<!-- left page -->