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
		$.ajax({
			type : "POST",
			url : "/ynm/login",
			contentType : "application/json",
			data : JSON.stringify(data),
			async: true,
			cache :false, // 캐시 여부
			success : function(result, response){
				history.back();
			},
			error   : function(result, textStatus, jqXHR){
				alert("error");
			}
		});
	}
	
}