<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link href="<c:url value="/resources/css/notice.css" />" rel="stylesheet">
<script src="<c:url value='/resources/js/common/attach.js'/>" charset="utf-8"></script>
<script src="<c:url value='/resources/js/notice/noticeEd.js'/>" charset="utf-8"></script>

	<form name="form" id="form" method="post" enctype="multipart/form-data">
		<div id="writeForm">
			<input type="hidden" name="MENU_CODE" value="B"> 
			<input type="hidden" name="FILE_GROUP"  id="FILE_GROUP" value="${FILE_GROUP}"> 
			
			<input type="hidden" name="IDX" value="${data.IDX}">
	
			<label for="exampleFormControlInput1">제목</label> 
			<input type="text" name="TITLE" value="${data.TITLE }" class="form-control">
	
			<label for="exampleFormControlInput1">작성자</label> 
			<input type="text" name="CREATE_ID" value="${data.CREATE_ID}" class="form-control">
	
		
			<label for="exampleFormControlTextarea1">내용</label>
			<textarea rows="5" name="CONTENTS" class="form-control">${data.CONTENTS}</textarea>
			
			
		  	<label for="exampleFormControlTextarea1">첨부파일</label>
		  	<div id="fileList">
			<c:forEach items="${files}" var="row" >
                <div>
			         ${row.ORG_FILE_NAME }  
			         <span> (${row.FILE_SIZE }byte)</span>
			         <button type="button" id="deleteFile" class="btn" data="${row.FILE_NO}">삭제</button>
		         </div>
	        </c:forEach>
		  	<input type="file" name="uploadFile" id="uploadFile"  multiple="multiple" class="form-control">
		  	</div>
		</div>
	 	<div id="btnGrp">
			<c:if test="${mode eq 'new' }">
				<button type="button" id="save" class="btn btn-success">등록</button>
			</c:if>
			<c:if test="${mode eq 'modify' }">
				<button type="button" id="update" class="btn btn-warning">수정</button>
			</c:if>
				<button type="button" id="list" class="btn btn-primary">목록</button>
		</div>
	</form>
