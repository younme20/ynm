<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<head>
	<script src="<c:url value='/resources/js/common/schedule.js'/>" charset="utf-8"></script>
	<title>first</title>
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
						<div class="form-group">
							<div class="row">
								<div class="col-sm-12">
									<label>할 일</label> <input type="text" id="TITLE" name="TITLE" class="form-control" value=""></input>
								</div>
							</div>
						</div>
						<div class="form-group">
							<div class="row">
								<div class="col-sm-12">
									<label>유 저</label> <input type="text" id="USERNAME" name="USERNAME" class="form-control" value="" disabled></input>
								</div>
							</div>
						</div>
						<div class="form-group">
							<div class="row">
								<div class="col-sm-6">
									<label>시작일시</label>
									<div class="input-group date" id="startDate" data-target-input="nearest">
										<input type="text" id="START_DATE" name="START_DATE" class="form-control datetimepicker-input" data-target="#startDate"/>
										<div class="input-group-append" data-target="#startDate" data-toggle="datetimepicker">
											<div class="input-group-text"><i class="fa fa-calendar"></i></div>
										</div>
									</div>
								</div>
								<div class="col-sm-6">
									<label>종료일시</label>
									<div class="input-group date" id="endDate" data-target-input="nearest">
										<input type="text" id="END_DATE" name="END_DATE" class="form-control datetimepicker-input" data-target="#endDate"/>
										<div class="input-group-append" data-target="#endDate" data-toggle="datetimepicker">
											<div class="input-group-text"><i class="fa fa-calendar"></i></div>
										</div>
									</div>
								</div>
							</div>
						</div>
						<div class="form-group">
							<div class="row">
								<div class="col-sm-12">
<%--							TODO:		select2로 바꾸기--%>
									<select id="COLOR" name="COLOR" class="form-control">
										<option value="#B40431" style="color:#B40431;">급함</option>
										<option value="#90d5eb" style="color:#58ACFA;" selected>보통</option>
										<option value="#D8D8D8" style="color:#D8D8D8;">여유</option>
									</select>
								</div>
							</div>
						</div>
						<div class="form-group">
							<div class="row">
								<div class="col-sm-12">
									<label>설명</label><textarea name="MEMO" id="MEMO" style="height: 50%" rows="10" class="form-control"></textarea>
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
</html>