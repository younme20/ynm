<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="https://code.jquery.com/jquery-3.4.1.min.js" type="text/javascript"></script>
<script src="<c:url value='/resources/js/common/common.js'/>"charset="utf-8"></script>
<script src="<c:url value='/resources/js/notice/notice.js'/>"charset="utf-8"></script>
<title>Insert title here</title>
</head>
<body>
	<div>
	    <form name="form" id="form" method="post">
	    	<input type="hidden" name="IDX" value="${data.IDX }">
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
	        
		    <button type="button" id="save">등록</button>
			<button type="button" id="list" >목록</button>
	    </form>
	</div>
</body>
</html>