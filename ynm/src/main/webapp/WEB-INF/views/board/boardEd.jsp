<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html lang="en">
<head>
</head>
<body>
	<div class="main-wrapper">
		<article class="post px-3 py-5 p-md-5">
			<form name="form1" id=form1 method="post" enctype="multipart/form-data">
				<!-- <input type="hidden" name="MENU_CODE" value="B">  -->
				<input type="hidden" name="FILE_GROUP"  id="FILE_GROUP" value="${FILE_GROUP}">
				<input type="hidden" name="HASHTAG" id="HASHTAG" value="${HASHTAG}"> 
				<input type="hidden" name="IDX" id="IDX" value="${data.IDX}">

				<div class="form-group">
					 <label class="control-label col-sm-2" for="TITLE">Title :</label>
					 <div class="col-sm-10">
				     	<input type="text" id="TITLE" name="TITLE" value="${data.TITLE }" class="form-control">
				     </div>
				</div>
				
				<div class="form-group">
					<label class="control-label col-sm-2" for="CREATE_ID">Writer :</label>
					<div class="col-sm-10">
						<input type="text" id="CREATE_ID" name="CREATE_ID" value="${username}"
							class="form-control" readonly="readonly">
					</div>
				</div>

				<div class="form-group">
					<label class="control-label col-sm-2" for="CATEGORY">Category :</label>
					<div class="row ml-0 mr-0">
						<div class="col-sm-5">
							<select type="select" id="selectCategory" name="selectCategory" class="form-control">
								<c:forEach items="${category}"  var="cg">
									<option id="${cg.IDX}" value="${cg.TITLE}" ${cg.IDX eq data.PARENT_IDX ? 'selected': ''}>${cg.TITLE}</option>
								</c:forEach>
							</select>
						</div>
						<div class="col-sm-5">
							<input type="text" id="CATEGORY" name="CATEGORY" value="" class="form-control"/>
						</div>
					</div>
				</div>
			
				<div class="form-group">
				 	<label class="control-label col-sm-2" for="summernote">Content :</label>
				 	<div class="col-sm-10">
						<textarea id="summernote" name="CONTENTS">${data.CONTENTS}</textarea>
					</div>
				</div>
			
				<div class="form-group">
			 		<label class="control-label col-sm-2" for="uploadFile">Attach Files :</label>
				 	<div class="col-sm-offset-2 col-sm-10">
					  	<div id="fileList">
							<c:forEach items="${files}" var="row" >
				                <div>
							         ${row.ORG_FILE_NAME }  
							         <span> (${row.FILE_SIZE }byte)</span>
							         <button type="button" id="deleteFile" class="btn btn btn-warning" data="${row.FILE_NO}">삭제</button>
						         </div>
					        </c:forEach>
				        </div>
						<div id="uploadScope" class="uploadScope">
							<div class="btn-icon">
								<button type="button" class="new-btn">Drag & Drop File Here</button>
							</div>
						</div>
			       		<input type="file" name="uploadFile" id="uploadFile" multiple style="display:none;">
				  	 </div>
				 </div>
			 
				 <div class="form-group">
					<label class="control-label col-sm-2" for="tag">Tags :</label>
					<div class="col-sm-offset-2 col-sm-10">
						<div id="tagList">
							<ul>
								<c:forEach var="item" items="${hash}" varStatus="idx">
									<li class="tag"><p>${item}</p><span id='delTag' class='fa fa-times'></span></li>
								</c:forEach>
							</ul>
						</div>
						<input type="text" name="tag" id="tag" class="form-control" placeholder="해시 태그를 입력하고 Enter 키를 누르세요.">
					</div>
				 </div>
				<div class="form-group">
					<div class="col-sm-10">
						<div class="new-btn-group btn-right pt-3">
							<c:if test="${mode eq 'new' }">
								<button type="button" id="save" class="btn-li new-btn">등록</button>
							</c:if>
							<c:if test="${mode eq 'modify' }">
								<button type="button" id="update" class="btn-li new-btn">수정</button>
							</c:if>
							<button type="button" id="list" class="btn-li new-btn">목록</button>
						</div>
					</div>
				</div>
			</form>
		</article>
	</div>
</body>
<script src="<c:url value='/resources/js/common/attach.js'/>" charset="utf-8"></script>
<script src="<c:url value='/resources/js/hashtag/hashtag.js'/>" charset="utf-8"></script>
<script src="<c:url value='/resources/js/board/boardEd.js'/>" charset="utf-8"></script>
</html>