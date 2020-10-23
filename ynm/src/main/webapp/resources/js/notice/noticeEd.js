$(document).ready(function(){
	$('#summernote').summernote({
           height: 300,                 
           minHeight: null,           
           maxHeight: null,             
           focus: true,                 
           lang: "ko-KR",					
			callbacks: {
				onImageUpload : function(files) {
					 attach.uploadFile(files[0]);
				},
				onPaste: function (e) {
					var clipboardData = e.originalEvent.clipboardData;
					if (clipboardData && clipboardData.items && clipboardData.items.length) {
						var item = clipboardData.items[0];
						if (item.kind === 'file' && item.type.indexOf('image/') !== -1) {
							e.preventDefault();
						}
					}
				}
			}
   });
	
	/**
	* 이미지 파일 업로드
	*/
	function uploadSummernoteImageFile(file, editor) {
		data = new FormData();
		data.append("file", file);
		$.ajax({
			data : data,
			type : "POST",
			url : "/uploadSummernoteImageFile",
			contentType : false,
			processData : false,
			success : function(data) {
            	//항상 업로드된 파일의 url이 있어야 한다.
				$(editor).summernote('insertImage', data.url);
			}
		});
	}
	   
	//목록
	$("#list").on("click", function(){
		movePage("/ynm/notice");
		// $("#form").submit();
	
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
				 if (jqXHR.status === 0) {
			            alert('Not connect.\n Verify Network.');
			        } 
			        else if (jqXHR.status == 400) {
			            alert('Server understood the request, but request content was invalid. [400]');
			        } 
			        else if (jqXHR.status == 401) {
			            alert('Unauthorized access. [401]');
			        } 
			        else if (jqXHR.status == 403) {
			            alert('Forbidden resource can not be accessed. [403]');
			        } 
			        else if (jqXHR.status == 404) {
			            alert('Requested page not found. [404]');
			        } 
			        else if (jqXHR.status == 500) {
			            alert('Internal server error. [500]');
			        } 
			        else if (jqXHR.status == 503) {
			            alert('Service unavailable. [503]');
			        } 
			        else if (exception === 'parsererror') {
			            alert('Requested JSON parse failed. [Failed]');
			        } 
			        else if (exception === 'timeout') {
			            alert('Time out error. [Timeout]');
			        } 
			        else if (exception === 'abort') {
			            alert('Ajax request aborted. [Aborted]');
			        } 
			        else {
			            alert('Uncaught Error.n' + jqXHR.responseText);
			        }
				movePage("/ynm/notice");
			}
		});
	},
	this.updateBoard = function(){ 
		var data = $("#form").serializeObject();
		$.ajax({
			type : "POST",                               
			url : "/ynm/notice/update",                         
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
	}
}
