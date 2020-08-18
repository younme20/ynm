/**
 * Notice List Script Page 
 */
$(document).ready(function(){
	//글쓰기
	$("#write").on("click", function(e){ 
		movePage("/ynm/notice//write");
	});
	
	//글보기
	$("#detail").on("click", function(){
		var idx = $(this).attr("id");
		movePage("/ynm/notice/detail/"+idx);
	});
	
	//검색
	$("#btnSerch").on("click", function(){
		var keyword = $("#keyword").val();
		var type = $("#searchType").val();
		movePage("/ynm/notice/serch/"+type +"/"+keyword);
	});
});
