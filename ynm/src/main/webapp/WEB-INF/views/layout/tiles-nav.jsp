<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- nav page -->
<div class="navbar">
    <div class="hamburger" id="hamburger-1">
        <span class="line"></span>
        <span class="line"></span>
        <span class="line"></span>
    </div>
    <div class="logo">
        StudyLog
    </div>
    <div class="btn">
         <c:if test="${isAuth}">
               <button type="button" id="btnWritePlan" class="new-btn"><i class="fa fa-calendar-alt"></i> 일정쓰기</button>
               <button type="button" id="btnLogout" class="new-btn"><i class="fa fa-sign-out-alt"></i> 로그아웃 </button>
          		<button type="button" id="btnWriteFrom" class="new-btn"><i class="fa fa-book-reader"></i> 글쓰기 </button>
           </c:if>
    </div>
</div>
<!-- nav page -->