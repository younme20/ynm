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
			url : "/login",
			json : true,
			contentType : "application/json",
			data : JSON.stringify(data),
			beforeSend: function(xhr) {
				xhr.setRequestHeader(header,token);
			},
			async: false,
			success : function(result, textStatus, jqXHR){
				alert("success");
				movePage("/ynm");
			},
			error   : function(result, textStatus, jqXHR){
				//alert("error");
				movePage("/ynm");
				console.log(result, textStatus, jqXHR);
			}
		});
	}
	
}