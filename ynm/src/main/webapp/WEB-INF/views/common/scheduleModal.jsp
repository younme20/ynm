<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>first</title>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
</head>
<body>
	<div class="modal fade" id="planModal" tabindex="-1" role="dialog" aria-labelledby="planModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">×</span></button>
					<h4 class="modal-title" id="planModalLabel">일정 추가</h4>
				</div>
				<form id="scheduleForm" name="scheduleForm">
					<input type="hidden" id="IDX" name="IDX" class="form-control" value=""></input>
					<input type="hidden"  name="${_csrf.parameterName}"   value="${_csrf.token}"/>

					<div class="modal-body">
						<div class="row">
							<div class="col-xs-12">
								<div class="col-xs-2">
									일정명 :  
								</div>
								<div class="col-xs-10">
									<input type="text" id="TITLE" name="TITLE" class="form-control" value=""></input>																					
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-xs-12">					
								<div class="col-xs-2">
									시작일 : 
								</div>
								<div class="col-xs-4">
									<input type="text" id="START_DATE" name="START_DATE" class="form-control" value=""></input>																					
								</div>
								<div class="col-xs-2">
									종료일 : 
								</div>	
								<div class="col-xs-4">
									<input type="text" id="END_DATE" name="END_DATE" class="form-control" value=""></input>																					
								</div>				
							</div>
						</div>	
						<div class="row">
							<div class="col-xs-12">
								<div class="col-xs-2">
									구분 : 
								</div>
								<div class="col-xs-10">	
									<input type="radio" id="category_1" name="category" value="B" checked="checked"> PUBLIC</input>
									<input type="radio" id="category_2" name="category" VALUE="V"> PRIVATE</input>																				
								</div>				
							</div>
						</div>	
						<div class="row">
							<div class="col-xs-12">
								<div class="col-xs-2">
									색상 : 
								</div>
								<div class="col-xs-10">	
									<input type="color" id="COLOR" name="COLOR" value=""></input>																					
								</div>				
							</div>
						</div>	
						<div class="row">
							<div class="col-xs-12">
								<div class="col-xs-2">
									설명 : 
								</div>
								<div class="col-xs-10">
									<textarea name="MEMO" id="MEMO" cols="40" rows="10" class="form-control"></textarea>
								</div>				
							</div>
						</div>													
					</div>
				</form>
				<div class="modal-footer">
					<button type="button" id="btnModalConfirm" class="btn btn-primary" data-dismiss="modal">확인</button>
					<button type="button" id="btnModalCancel" class="btn btn-secondary" data-dismiss="modal">취소</button>
					<button type="button" id="btnModalDelete" class="btn btn-danger" data-dismiss="modal">삭제</button>					
				</div>
			</div>
		</div>
	</div>
</body>
<script src="<c:url value='/resources/js/common/common.js'/>" charset="utf-8"></script>
<script src="<c:url value='/resources/js/common/schedule.js'/>" charset="utf-8"></script>
</html>