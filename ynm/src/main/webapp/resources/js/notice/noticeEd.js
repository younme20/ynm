$(document).ready(function(){
	//목록
	$("#list").on("click", function(){
		//movePage("/ynm/notice");
		 $("#form").submit();
	
	});
	
	//글저장
	$("#save").on("click", function(e){ 
		notice.insertBoard();
	});
	
	//수정폼
	$("#modify").on("click", function(e){ 
		var idx = $(this).attr("data");
		movePage("/ynm/notice/modify/"+idx);
	});
	//수정
	$("#update").on("click", function(e){ 
		notice.updateBoard();
	});
	
	//삭제
	$("#delete").on("click", function(e){ 
		var idx = $(this).attr("data");
		movePage("/ynm/notice/delete/"+idx);
	});
	 
	//파일업로드2
	$("#uploadFile").on('change', function() {
		 notice.multiUploadFile();
	});
	
	notice = new noticeEdit();	
	
	
});
function noticeEdit() {
	this.init = function(){
		
	},
	this.insertBoard = function(){ 
		var formData = $("#form").serializeObject();
		$.ajax({
			type : "POST",                               
			url : "/ynm/notice/insert",
			data: formData, 
			cache: false, 
			json:true,
			success : function(result, textStatus, jqXHR){
				alert('등록되었습니다.'+result);
				movePage(result);
			},
			error   : function(result, textStatus, jqXHR){
				alert('실패!');
				movePage("/ynm/notice");
			}
		});
	},
	this.updateBoard = function(){ 
		var data = $("#form").serializeObject();
		$.ajax({
			type : "POST",                               
			url : "/ynm/notice/update/",                         
			data : data,
			json:true,
			success : function(result, textStatus, jqXHR){
				alert('수정되었습니다.');
				movePage("/ynm/notice/detail/"+result);
			},
			error   : function(result, textStatus, jqXHR){
				//alert('전송실패!');
				movePage("/ynm/notice");
			}
		});
	},
		this.multiUploadFile = function(){ 
			var formData = new FormData($('#form')[0]);

			$.ajax({
				type : "POST",         
				enctype: 'multipart/form-data',
				url : "/ynm/attach/multipartUpload",
				data: formData, 
				processData: false,  
				contentType: false,  
				cache: false, 
				success : function(result, textStatus, jqXHR){
					alert('업로드 성공'+result);
				},
				error   : function(result, textStatus, jqXHR){
					alert('업로드 실패!');
					console.log("code:"+result.status+"\n"+"message:"+result.responseText+"\n"+"error:"+textStatus);

				}
			});
		}
}