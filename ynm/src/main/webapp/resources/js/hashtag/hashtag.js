/**
 * hash tag js
 */
$(document).ready(function () {

    var arr = [];
    $("#tag").on("keypress", function (e) {
        var tag = $(this);

        if (e.keyCode == 13) {
        	var word = tag.val().replace(/(\s*)/g,"");
        	if(word){
        		//console.log(word);
        		arr.push(word);
        		$("#tlist").append("<li class='titem'>"+word+"<span id='delTag' class='glyphicon glyphicon-remove'></span></li>");
        		tag.val("");
        	}
        }
        $("#HASHTAG").val(arr.join());
        //console.log(arr.join());
        
       /* for (var i = 0; i < arr.length; i++) {
            console.log(arr[i]);
        }  */
    });

});
