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
	

});




