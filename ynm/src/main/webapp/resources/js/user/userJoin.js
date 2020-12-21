/**
 * 
 */
$(document).ready(function(){
	$("#btnJoin").on("click", function(e){
		if(joinCheck() == true)join.insertUser();
	});
	
	join = new userFunction();
});
function joinCheck(){
	var isRight = true;
	
	var username = $("#username");
	var password = $("#password");
	
	if(username.val().trim() == ""){
		 alert(username.attr("data-name")+" 입력하세요.");
		 isRight = false;
		 username.focus();
	}else if(password.val().trim() == ""){
		 alert(password.attr("data-name")+" 입력하세요.");
		 isRight = false;
		 password.focus();
	}
	 return isRight
}

function userFunction() {
	this.init = function(){

		
	},
	this.insertUser = function(){
		var data = $("#myForm").serializeObject();
		alert(contextPath);
		$.ajax({
			type : "POST",
			url : contextPath+"/join",
			contentType : "application/json",
			data : JSON.stringify(data),
			async: true,
			cache :false, // 캐시 여부
			success : function(result, response){
				alert("정상적으로 회원가입되었습니다.");
				movePage(contextPath+"/login");
			},
			error   : function(result, textStatus, jqXHR){
				alert("error"+jqXHR);
			}
		});
	}
}