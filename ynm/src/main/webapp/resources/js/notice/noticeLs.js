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
	/*var emptyCheck = function(frm){
		if(form.keyword.value == ""){
		    alert("검색어 입력 해주세요.");
		    return false;
		  }
		  return true;
	}*/

});
var pageMove  = function(obj){
	var pageIndex = $(obj).attr("pageidx");
	movePage("/ynm/notice/"+pageIndex);
};
