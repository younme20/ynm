/**
 * hash tag js
 */
var arr_ori = [];


$(document).ready(function () {
	$(document).on("click", "#delTag", function(){

		var word = $(this).parents("li");
		word.remove();
    	alert("선택 된 태그 삭제"+word.text());
    	console.log(arr_ori);
    });
	
    $("#tag").on("keypress", function (e) {
    	var tag = $(this);
        if (e.keyCode == 13) {
        	var word = tag.val().replace(/(\s*)/g,"");
        	getTag(word);
        }
       /* for (var i = 0; i < arr.length; i++) {
            console.log(arr[i]);
        }  */
    });
    
  
});
var getTag  = function(word){
	if(word){
		var arr_final = [];
		arr_ori.push(word);
	}
	
	$.each(arr_ori,function(i,value){
	    if(arr_final.indexOf(value) == -1 ){
	    	alert("체크:"+arr_final.indexOf(value));
	    	arr_final.push(value);
	    	$("#tlist").append("<li class='titem'>"+value+"<span id='delTag' class='glyphicon glyphicon-remove'></span></li>");
			
			$("#tag").val("");
	    }
	    
	    $("#HASHTAG").val(arr_final.join());
	});
}
