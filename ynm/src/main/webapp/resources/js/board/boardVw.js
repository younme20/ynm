/**
 * 
 */
$(document).ready(function(){
	//목록
	$("#list").on("click", function(){
		movePage("/ynm/board");
	
	});
	//수정폼
	$("#modify").on("click", function(e){ 
		var idx = $(this).attr("data");
		movePage("/ynm/board/modify/"+idx);
	});
	
	//삭제
	$("#delete").on("click", function(e){ 
		var idx = $(this).attr("data");
		movePage("/ynm/board/delete/"+idx);
	});	
});

