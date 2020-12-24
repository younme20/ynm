/**
 * board Edit js
 */
$(document).ready(function(){

	$("#selectCategory").trigger("change");

	$("#CATEGORY").blur(function() {
		if($(this).val() == ""){
			$("#selectCategory").attr("disabled", false);
		}else{
			$("#selectCategory").attr("disabled", true);
		}
	});
	
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
		movePage(contextPath);
	
	});
	
	//글저장
	$("#save").on("click", function(e){ 
		board.insertBoard();
	});
	
	//수정폼
	$("#modify").on("click", function(e){ 
		var idx = $(this).attr("data");
		movePage(contextPath+"/board/modify/"+idx);
	});
	//수정
	$("#update").on("click", function(e){ 
		board.updateBoard();
	});
	
	//삭제
	$("#delete").on("click", function(e){ 
		var idx = $(this).attr("data");
		movePage(contextPath+"/board/delete/"+idx);
	});
	 
	board = new boardEdit();	
});


function boardEdit() {
	this.init = function(){
		
	},
	this.insertBoard = function(){
		const formData = board.setFormDate();

		$.ajax({
			type : "POST",                               
			url : contextPath+"/user/usercheck",
			data: formData, 
			cache: false, 
			json:true,
			success : function(result, textStatus, jqXHR){
				alert('등록되었습니다.'+result);
				movePage(result);
			},
			error   : function(result, textStatus, jqXHR){
				alert('Uncaught Error.n' + jqXHR.responseText);
			    movePage(contextPath);
			}
		});
	},
	this.updateBoard = function(){
		const formData = board.setFormDate();

		$.ajax({
			type : "POST",                               
			url : contextPath+"/board/update",
			data : formData,
			json:true,
			success : function(result, textStatus, jqXHR){
				alert('수정되었습니다.');
				movePage(contextPath+"/board/"+result);
			},
			error   : function(result, textStatus, jqXHR){
				//alert('전송실패!');
				movePage(contextPath+"");
			}
		});
	}, this.setFormDate = function () {
		const formData = $("#form1").serializeObject();

		//카테고리 수정
		if($("#CATEGORY").val() == null || $("#CATEGORY").val() === ""){
			formData["CATEGORY"] = $("#selectCategory option:selected").val();
			formData["CATEGORY_TYPE"] = "EDIT";
			formData["PARENT_IDX"] = $("#selectCategory option:selected").attr("id");
		//카테고리 신규
		}else{
			formData["CATEGORY_TYPE"] = "NEW";
		}
		return formData;
	}
}
