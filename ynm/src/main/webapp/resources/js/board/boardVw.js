/**
 * 
 */
$(document).ready(function(){
	//목록
	$("#list").on("click", function(){
		movePage(contextPath+"/board");
	
	});
	//수정폼
	$("#modify").on("click", function(e){ 
		var idx = $(this).attr("data");
		movePage(contextPath+"/board/modify/"+idx);
	});
	
	//삭제
	$("#delete").on("click", function(e){ 
		var idx = $(this).attr("data");
		movePage(contextPath+"/board/delete/"+idx);
	});	
});

