<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	
	    <form name="form" id="form" method="post">
	    	<input type="hidden" name="IDX" value="${data.IDX}">
	        <div class="form-group">
	            <label for="exampleFormControlInput1">제목</label>
	            <input type="text" name="TITLE" value="${data.TITLE }"  class="form-control">
	        </div>
	        <div class="form-group">
	            <label for="exampleFormControlInput1">작성자</label>
	            <input type="text" name="CREATE_ID" value="${data.CREATE_ID}"  class="form-control">
	        </div>
	        <div class="form-group">
	            <label for="exampleFormControlTextarea1">내용</label>
	            <textarea rows="5" name="CONTENTS"  class="form-control">${data.CONTENTS}</textarea>
	        </div>
	         <c:if test="${mode eq 'new' }"> 
	           <button type="button" id="save" class="btn btn-success">등록</button>
	        </c:if>
	         <c:if test="${mode eq 'modify' }"> 
	           <button type="button" id="update" class="btn btn-warning">수정</button>
	        </c:if>
			<button type="button" id="list" class="btn btn-default">목록</button>
	    </form>
	