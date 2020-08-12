/**
 * 
 */
$(document).ready(function(){ 
	
	$("a[name='title']").on("click", function(e){ 
		//e.preventDefault();
		var idx = $(this).attr("idx");
		movePage("/ynm/study/view/"+idx);
	});
	
	$("a[name='index']").on("click", function(e){ 
		var idx = $(this).text();
		movePage("/ynm/study?pageIndex="+idx);
	});
	
	$("#btnWrite").on("click", function(e){ 
		var idx = 
		movePage("/ynm/study/edit/"+(length+1));
	});
	
	$("#btnSearch").on("click", function(e){
		var data = {
			"searchText" : $("#searchText").val(),
			"searchCondition" : $("#searchCondition option:selected").val(),
		};
		movePage("/ynm/study?searchCondition="+data.searchCondition+"&searchText="+data.searchText);		
	});
	

});




