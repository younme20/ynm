<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="https://code.jquery.com/jquery-3.4.1.min.js" type="text/javascript"></script>
<script src="<c:url value='/resources/js/common/common.js'/>"charset="utf-8"></script>
<script src="<c:url value='/resources/js/notice/noticeJs.js'/>"charset="utf-8"></script>
<title>Insert title here</title>
</head>
<body>
공지사항 form
	<div>
	    <form name="writeForm" id="writeForm" method="post">
	    	<input type="hidden" name="idx" value="${data.IDX }">
	        <div class="form-group">
	            <label for="exampleFormControlInput1">제목</label>
	            <input type="text" name="title" value="${data.TITLE }">
	        </div>
	        <div class="form-group">
	            <label for="exampleFormControlInput1">작성자</label>
	            <input type="text" name="cre_id" value="${data.CREATE_ID }">
	        </div>
	        <div class="form-group">
	            <label for="exampleFormControlTextarea1">내용</label>
	            <textarea rows="10" name="contents">${data.CONTENTS }</textarea>
	        </div>
	        
		    <button id="insert" onClick="fn_insert()">등록</button>
			<button id="delete" onClick="fn_delete()">삭제</button>
			<button id="list" onClick="fn_list()">목록</button>
	    </form>
	</div>
</body>
</html>