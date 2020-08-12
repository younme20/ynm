$(document).ready(function(){
	//목록
	$("#list").on("click", function(){
		movePage("/ynm/notice");
	});
	
	//글저장
	$("#save").on("click", function(e){ 
		notice.insertBoard();
	});
	
	//수정
	$("#modify").on("click", function(e){ 
		var idx = $(this).attr("id");
		movePage("/ynm/notice/modify/"+idx);
	});
	
	//글삭제
	$("#delet").on("click", function(e){ 
		var idx = $(this).attr("id");
		movePage("/ynm/notice/detail/"+idx);
	});
	notice = new noticeEdit();	
});

function noticeEdit() {
	this.init = function(){
		
	},
	this.insertBoard = function(){ 
		var data = $("#form").serializeObject();
		alert(data);
		
		$.ajax({
			type : "POST",                               
			url : "/ynm/notice/insert",                         
			data : data,
			json:true,
			success : function(result, textStatus, jqXHR){
				console.log("idx:"+result);
				alert('등록되었습니다.');
			},
			error   : function(result, textStatus, jqXHR){
				//alert('전송실패!');
				movePage("/ynm/notice");
			}
		});
	}

}