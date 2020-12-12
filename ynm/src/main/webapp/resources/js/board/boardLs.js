/**
 *
 */
$(document).ready(function(){
	
	$("#writeFrom").on("click", function(e){ 
		movePage("/ynm/board/edit");
	});
    
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

    $(".tag").on("click", function(e){
    	board.searchTagBoard($(this).attr("id"));
    });

    $("#btnWrite").on("click", function(e){
        var length = $(this).attr("length") * 1;
        movePage("/ynm/board/edit/"+(length+1));
    });

    board = new boardList();
});

function boardList() {
    this.init = function(){


    },
	this.searchTagBoard = function(tag){ 

    	movePage("/ynm/"+tag);	
	},
	this.searchBoard = function(index){ 

    	
		var data = {
				"searchText" : $("#searchText").val(),
				"searchCondition" : $("#searchCondition option:selected").val(),
				"index" : index
		};
		movePage("/ynm/board?pageIndex="+data.index+"&searchCondition="+data.searchCondition+"&searchText="+data.searchText);	
	}
}