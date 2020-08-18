<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
	<table border="1">
		<tr>
			<td>제목: ${data.TITLE }</td>
		</tr>
		<tr>
			<td>작성자: ${data.CREATE_ID }</td>
		</tr>
		<tr>
			<td>작성일: ${data.CREATE_DATETIME}</td>
		</tr>
		<tr>
			<td>
				<div>${data.CONTENTS }</div>
			</td>
		</tr>
	</table>
	<button type="button" id="modify" data="${data.IDX}">수정</button>
	<button type="button" id="delete" data="${data.IDX}">삭제</button>
	<button type="button" id="list">목록</button>
