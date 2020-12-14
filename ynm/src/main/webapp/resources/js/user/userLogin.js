/**
 * 
 */
const contextPath = getContextPath();

$(document).ready(function(){
	
	$("#btnLogin").on("click", function(e){
		user.authLogin();
	});

	$("#btnLogout").on("click", function(e){
		movePage(contextPath+"/out");
	});

	$("#btnMoveLoginPage").on("click", function(e){
		movePage(contextPath+"/login");
	});
	
	$("#join").on("click", function(e){ 
		movePage(contextPath+"/userjoin");
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
			url : contextPath+"/login",
			contentType : "application/json",
			data : JSON.stringify(data),
			async: true,
			cache :true, // 캐시 여부
			success : function(result, response){
				alert("정상적으로 로그인되었습니다.");
				movePage(contextPath);
			},
			error   : function(result, textStatus, jqXHR){
				alert("error");
			}
		});
	}
}