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

	notice = new noticeEdit();	
});

function noticeEdit() {
	this.init = function(){
		
	},
	this.insertBoard = function(){ 
		var data = $("#form").serializeObject();
		//data = JSON.stringify(data)
		alert(data);
		
		$.ajax({
			type : "POST",                               
			url : "/ynm/notice/insert",                         
			data : data,
			//dataType: "json", 
			//contentType: "application/json",
			json:true,
			success : function(result, textStatus, jqXHR){
				alert('전송성공!');
			},
			error   : function(result, textStatus, jqXHR){
				//alert('전송실패!');
				movePage("/ynm/notice");
			}
		});
	}

}