/**
 * 
 */
$(document).ready(function(){

});

function movePage(url) {
	location.href = url;	
}

function sideBarClick(idx){
	let item = $("li[id=item_"+idx+"]");

	if(item.css("display") == "block"){
		item.css("display", "none");
		$("#btn_"+idx+" > i").attr("class", "fa fa-plus");
	}else{
		item.css("display", "block");
		$("#btn_"+idx+" > i").attr("class", "fa fa-minus");
	}
}







