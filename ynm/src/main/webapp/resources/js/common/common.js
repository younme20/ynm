/**
 * 
 */
$(document).ready(function(){
	const PARENT_IDX = $("#PARENT_IDX").val();

	if(PARENT_IDX != null){
		sideBarClick(PARENT_IDX);
	}
});

function movePage(url) {
	location.href = url;	
}

function sideBarClick(idx){

	let item = $("li[group="+idx+"]");

	if(item.css("display") == "block"){
		item.css("display", "none");
		$("#btn_"+idx+" > i").attr("class", "fa fa-plus");
	}else{
		item.css("display", "block");
		$("#btn_"+idx+" > i").attr("class", "fa fa-minus");
	}
}

function getContextPath() {
	const hostIndex = location.href.indexOf(location.host) + location.host.length;
	return location.href.substring(0, hostIndex);
}










