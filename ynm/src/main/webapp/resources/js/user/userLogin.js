/**
 * 
 */
$(document).ready(function(){
	
	$("#btnLogin").on("click", function(e){
		user.authLogin();
	});

	user = new userLogin();
});

function userLogin() {
	this.init = function(){

		
	},
	this.authLogin = function(){
		var data = $("#myForm").serializeObject();
		var token = $("meta[name='_csrf']").attr("content");
		var header = $("meta[name='_csrf_header']").attr("content");

		$.ajax({
			type : "POST",
			url : "/ynm/login",
			json : true,
			contentType : "application/json",
			data : JSON.stringify(data),
			async: true,
			cache :false, // 캐시 여부
			success : function(result, response){
				alert("success");
				console.log("success...?"+result, response);
				movePage("/ynm");
			},
			error   : function(result, textStatus, jqXHR){
				alert("error");
				console.log(result, textStatus, jqXHR);
			}
		});
	}
	
}