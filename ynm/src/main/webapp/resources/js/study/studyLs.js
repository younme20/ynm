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
		var length = $(this).attr("length") * 1;
		movePage("/ynm/study/edit/"+(length+1));
	});
	
	$("#btnSearch").on("click", function(e){
		var data = {
			"searchTitle" : $("#searchText").val()
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




