<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<div>
	    <form name="form" id="form" method="post">
	    	<input type="hidden" name="IDX" value="${data.IDX}">
	        <div class="form-group">
	            <label for="exampleFormControlInput1">제목</label>
	            <input type="text" name="TITLE" value="${data.TITLE }">
	        </div>
	        <div class="form-group">
	            <label for="exampleFormControlInput1">작성자</label>
	            <input type="text" name="CREATE_ID" value="${data.CREATE_ID}">
	        </div>
	        <div class="form-group">
	            <label for="exampleFormControlTextarea1">내용</label>
	            <textarea rows="10" name="CONTENTS">${data.CONTENTS}</textarea>
	        </div>
	         <c:if test="${mode eq 'new' }"> 
	           <button type="button" id="save">등록</button>
	        </c:if>
	         <c:if test="${mode eq 'modify' }"> 
	           <button type="button" id="update">수정</button>
	        </c:if>
			<button type="button" id="list" >목록</button>
	    </form>
	</div>