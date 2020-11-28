/**
 * 
 */
$(document).ready(function(){
	
	$("#btnLogin").on("click", function(e){
		user.authLogin();
	});
	
	$("#join").on("click", function(e){ 
		movePage("/ynm/userjoin");
	})

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
				alert("정상적으로 로그인되었습니다.");
				movePage("/ynm");
			},
			error   : function(result, textStatus, jqXHR){
				alert("error");
			}
		});
	}
}