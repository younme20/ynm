/**
 * Notice List Script Page 
 */
	
$(document).ready(function(){
	//글쓰기
	$("#write").on("click", function(e){ 
		movePage("/ynm/notice//write");
	});

});

//글보기
var detaile = function(idx){
	 $("#form").attr("action", "notice/detail/"+idx);
	 $("#form").submit();
}

var pageMove  = function(obj){
	var index = $(obj).attr("pageidx");
	movePage("/ynm/notice?pageIndex="+index);
}
