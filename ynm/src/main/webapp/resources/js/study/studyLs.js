/**
 * 
 */
$(document).ready(function(){ 
	
	$("a[name='title']").on("click", function(e){ 
		//e.preventDefault();
		var idx = $(this).attr("idx");
		movePage("/ynm/study/view/"+idx);
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
		$.ajax({
			type : "POST",                               
			url : "/ynm/study/search",                   
			json : true,                           
			data : data,                 
			success : function(result, textStatus, jqXHR){
				
			},
			error   : function(result, textStatus, jqXHR){
				
			}
		});		
		
	});
	

});




