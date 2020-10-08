<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link href="<c:url value="/resources/css/notice.css" />" rel="stylesheet">
<script src="<c:url value='/resources/js/common/attach.js'/>" charset="utf-8"></script>
<script src="<c:url value='/resources/js/notice/noticeEd.js'/>" charset="utf-8"></script>

<div class="container">
	<form name="form" id="form" method="post" enctype="multipart/form-data">
		
			<input type="hidden" name="MENU_CODE" value="B"> 
			<input type="hidden" name="FILE_GROUP"  id="FILE_GROUP" value="${FILE_GROUP}"> 
			
			<input type="hidden" name="IDX" value="${data.IDX}">
		
		<div class="form-group">
			 <label class="control-label col-sm-2" for="email">제목 :</label>
			 <div class="col-sm-10">
		     	<input type="text" name="TITLE" value="${data.TITLE }" class="form-control">
		     </div>
		</div>
		
		<div class="form-group">
			<label class="control-label col-sm-2" for="email">작성자 :</label>
			<div class="col-sm-10">
				<input type="text" name="CREATE_ID" value="${data.CREATE_ID}"
					class="form-control">
			</div>
		</div>
		
		<div class="form-group">
		 	<label class="control-label col-sm-2" for="email">내용 :</label>
		 	<div class="col-sm-10">
				<textarea id="summernote" name="CONTENTS" class="form-control">${data.CONTENTS}</textarea>
			</div>
		</div>
		
		<div class="form-group">
	 		<label class="control-label col-sm-2" for="email">첨부파일 :</label>
		 	<div class="col-sm-offset-2 col-sm-10">
			  	<div id="fileList">
					<c:forEach items="${files}" var="row" >
		                <div>
					         ${row.ORG_FILE_NAME }  
					         <span> (${row.FILE_SIZE }byte)</span>
					         <button type="button" id="deleteFile" class="btn" data="${row.FILE_NO}">삭제</button>
				         </div>
			        </c:forEach>
		        </div>
		  		<div id="uploadScope" class="uploadScope">Drag & Drop File Here</div>
	       		<input type="file" name="uploadFile" id="uploadFile" multiple style="display:none;">
		  	 </div>
		 </div>
		  	 
	 	<div class="form-group button">        
	      	<div class="col-sm-offset-2 col-sm-10">
				<c:if test="${mode eq 'new' }">
					<button type="button" id="save" class="btn btn-success">등록</button>
				</c:if>
				<c:if test="${mode eq 'modify' }">
					<button type="button" id="update" class="btn btn-warning">수정</button>
				</c:if>
					<button type="button" id="list" class="btn btn-primary">목록</button>
			</div>
		</div>
	</form>
</div>