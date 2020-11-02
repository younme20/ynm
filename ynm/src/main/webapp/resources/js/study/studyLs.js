/**
 * 
 */
$(document).ready(function(){ 		
	$("#searchCondition").trigger("change");
	
	$("a[name='index']").each(function(){
		var idx = $(this);
		
		if(idx.attr("pageidx") === idx.text()) {
			$("#index_"+idx.text()).css("font-weight", "bold");
		}
	});
	
	$("a[name='title']").on("click", function(e){ 
		var idx = $(this).attr("idx");
		movePage("/ynm/board/detail/"+idx);
	});
	
	$("a[name='index']").on("click", function(e){ 
		study.searchBoard($(this).text());
	});
	
	$("#btnWrite").on("click", function(e){ 
		var length = $(this).attr("length") * 1;
		movePage("/ynm/study/edit/"+(length+1));
	});
	
	$("#btnSearch").on("click", function(e){
		study.searchBoard(1);
	});	
	
	study = new studyList();	
});

function studyList() {
	this.init = function(){

		
	},
	this.searchBoard = function(index){ 
		var data = {
				"searchText" : $("#searchText").val(),
				"searchCondition" : $("#searchCondition option:selected").val(),
				"index" : index
		};
		movePage("/ynm/study?pageIndex="+data.index+"&searchCondition="+data.searchCondition+"&searchText="+data.searchText);	
	}
	
}