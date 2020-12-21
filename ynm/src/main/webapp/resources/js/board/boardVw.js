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
		var data = {
			"IDX":$(this).attr("data")
		};
		$.ajax({
			type : "POST",
			url : contextPath+"/board/delete",
			json : true,
			data : data,
			success : function(result, textStatus, jqXHR){
				alert('삭제되었습니다.');
				movePage(contextPath);
			},
			error   : function(result, textStatus, jqXHR){
				movePage(contextPath);
			}
		});
	});	
});

