$(document).ready(function(){
	//목록
	$("#list").on("click", function(){
		movePage("/ynm/notice");
	});
	
	//글쓰기
	$("#write").on("click", function(e){ 
		movePage("/ynm/notice/form");
	});
	
	
	//저장
	$("#save").on("click", function(e){ 
		notice.insertBoard();
	});
	
	
	//상세보기
	$("#detail").on("click", function(){
		var idx = $(this).attr("id");
		movePage("/ynm/notice/detail/"+idx);
	});

/*	$("#modifyFrom").on("click", function(){
		alert('수정폼 이동');
		//movePage("/ynm/modifyForm");

	});

	$("#delete").on("click", function(){
		alert('삭제 이동');
		//movePage("/ynm/noticeDelete");

	});*/
	notice = new noticeEdit();	
});

function noticeEdit() {
	this.init = function(){
		
	},
	this.insertBoard = function(){ 
		var data = $("#form").serialize();
		alert(data);
		
		$.ajax({
			type : "POST",                               
			url : "/ynm/notice/insert",                         
			data : JSON.stringify(data),
			dataType: "json", 
			contentType: "application/json",
			success : function(result, textStatus, jqXHR){
				alert('전송성공!');
			},
			error   : function(result, textStatus, jqXHR){
				//alert('전송실패!');
				movePage("/ynm/notice");
			}
		});
	},
	this.updateBoard = function(){ 
		var data = {
			"IDX": $("#IDX").val(),
			"TITLE": $("#TITLE").val(),
			"CONTENTS": $('#summernote').summernote('code')
		};
		$.ajax({
			type : "POST",                               
			url : "/ynm/study/update",                   
			json : true,                           
			data : data,                 
			success : function(result, textStatus, jqXHR){
				alert('전송성공!');
			},
			error   : function(result, textStatus, jqXHR){
				movePage("/ynm");
			}
		});		
	}
	
}