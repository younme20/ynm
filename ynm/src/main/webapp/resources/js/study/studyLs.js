/**
 * 
 */
$(document).ready(function(){ 
	
	$("a[name='index']").each(function(){
		var idx = $(this);
		
		if(idx.attr("pageidx") === idx.text()) {
			$("#index_"+idx.text()).css("font-weight", "bold");
		}
	});
	
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
		var length = $(this).attr("length") * 1;
		movePage("/ynm/study/edit/"+(length+2));
	});
	
	$("#btnSearch").on("click", function(e){
		var data = {
			"searchText" : $("#searchText").val(),
			"searchCondition" : $("#searchCondition option:selected").val(),
		};
		movePage("/ynm/study?pageIndex=1&searchCondition="+data.searchCondition+"&searchText="+data.searchText);		
	});
	

});




