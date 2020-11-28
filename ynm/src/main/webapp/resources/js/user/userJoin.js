/**
 * 
 */
$(document).ready(function(){
	$("#btnJoin").on("click", function(e){
		join.insertUser(e);
	});
	
	join = new userFunction();
});

function userFunction() {
	this.init = function(){

		
	},
	this.insertUser = function(e){
		var data = $("#myForm").serializeObject();
		alert(data);
		$.ajax({
			type : "POST",
			url : "/ynm/join",
			contentType : "application/json",
			data : data,
			async: true,
			cache :false, // 캐시 여부
			success : function(result, response){
				alert("정상적으로 회원가입되었습니다.");
				movePage("/ynm/login");
			},
			error   : function(result, textStatus, jqXHR){
				alert("error"+textStatus);
			}
		});
	}
}