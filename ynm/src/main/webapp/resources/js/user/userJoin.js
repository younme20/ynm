/**
 * 
 */
$(document).ready(function(){
	$("#btnJoin").on("click", function(e){
		if(joinCheck() == true)join.insertUser();
	});
	
	$.fn.delayKeyup = function(callback, ms){
	    var timer = 0;
	    var el = $(this);
	    $(this).keyup(function(){                   
	    clearTimeout (timer);
	    timer = setTimeout(function(){
	        callback(el)
	        }, ms);
	    });
	    return $(this);
	};

	$('#username').delayKeyup(function(e){
	   join.selectUserCheck(e.val());
	},700);
	
	join = new userFunction();
});
var joinCheck = function(){
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


var userFunction = function() {
	this.init = function(){

		
	},
	this.insertUser = function(){
		var formData = $("#myForm").serializeObject();
		alert(contextPath);
		$.ajax({
			type : "POST",
			url : contextPath+"/join",
			contentType : "application/json",
			data : JSON.stringify(formData),
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
	},this.selectUserCheck = function(id){
		const formData = new FormData();
		formData.append("USERNAME", id);
		alert(contextPath+"/join/usercheck");
		$.ajax({
			type : "POST",                               
			url : contextPath+"/join/usercheck",
			data: formData, 
			cache: false, 
			contentType: false,
			processData: false,
			success : function(result, textStatus, jqXHR){
				alert('사용가능합니다.'+result);
			},
			error   : function(result, textStatus, jqXHR){
				alert('UserName Check Error.n' + jqXHR.responseText);
			}
		});
	}
}