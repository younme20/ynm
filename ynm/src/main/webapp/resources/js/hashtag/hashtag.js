/**
 * hash tag js
 */
var arr_ori = [];
var arr_final = [];

$(document).ready(function () {
	var hash = $("#HASHTAG").val();
	 if(!hash == ""){
		arr_ori = hash.split(",");
		
	}
	 
   //태그 검색
   $(document).on("click", ".titem", function(){

     var word = $(this).text().toString();

   	 $("#form").attr("action", contextPath+"/notice/"+word);
	 $("#form").submit();
   
    });
   
    //태그 삭제
   $(document).on("click", "#delTag", function(){
    var word = $(this).parents("li");
    var idx = arr_ori.indexOf(word.text());
        if(idx  > -1){
            arr_ori.splice(idx, 1);
            arr_final = arr_ori;
            tagList();
        }
        alert("선택 된 태그 삭제 "+word.text());
    });
   

   //태그 등록
    $("#tag").on("keypress", function(e){
        if (e.keyCode == 13) {
           var word = $(this).val().replace(/(\s*)/g,"").replace( /[\{\}\[\]\/?.,;:|\)*~`!^\-_+<>@\$%&\\\=\(\'\"]/gi,"");
           arr_final = [];
            if(word){
                    arr_ori.push(word);
                    $.each(arr_ori,function(i,value){
                        if(arr_final.indexOf(value) == -1 ){
                            arr_final.push(value);
                        }
                    });
                    tagList();
            }
        }
    });
  
});

var tagList = function(){
    $("#tagList ul li").remove();
    for (var i = 0; i < arr_final.length; i++) {
            $("#tagList ul").append("<li class='tag'><p>"+arr_final[i]+"</p><span id='delTag' class='fa fa-times'></span></li>");
        } 
        $("#tag").val("");
        $("#HASHTAG").val(arr_final.join());
         arr_ori = arr_final
}