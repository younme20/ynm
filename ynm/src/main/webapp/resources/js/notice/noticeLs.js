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
	$("#btnSerch").on("click", function(e){
		var keyword = $("#keyword").val();
		var searchType = $("#searchType").val();
		
		if(keyword == ""){
			alert("검색 단어를 입력하세요");
			$("#keyword").focus();
			return false;
		}
		
		movePage("/ynm/notice/serch/"+searchType +"/"+keyword);
	});
});
