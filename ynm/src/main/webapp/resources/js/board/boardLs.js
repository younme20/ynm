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
        var idx = $(this).attr("idx");
        movePage("/ynm/board/detail/"+idx);
    });

    $("a[name='index']").on("click", function(e){
        study.searchBoard($(this).text());
    });

    $("#btnWrite").on("click", function(e){
        var length = $(this).attr("length") * 1;
        movePage("/ynm/board/edit/"+(length+1));
    });

    board = new boardList();
});

function boardList() {
    this.init = function(){


    }
}