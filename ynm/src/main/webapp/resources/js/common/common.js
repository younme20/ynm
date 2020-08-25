/**
 * 
 */
function movePage(url) {
	location.href = url;	
}

function ymDataObj() {
	this.ymDataObj = {};	
}

ymDataObj.prototype.addParam = function(dataObj) {
	
	this.ymDataObj.requestParam = $.extend(this.ymDataObj.requsetParam, dataObj);
}


