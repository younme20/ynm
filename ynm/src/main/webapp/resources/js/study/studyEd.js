/**
 * 
 */
var study = null;
$(document).ready(function(){ 
		
    $('#summernote').summernote({
        tabsize: 2,
        height: 120,
        toolbar: [
          ['style', ['style']],
          ['font', ['bold', 'underline', 'clear']],
          ['color', ['color']],
          ['para', ['ul', 'ol', 'paragraph']],
          ['table', ['table']],
          ['insert', ['link', 'picture', 'video']],
          ['view', ['fullscreen', 'codeview', 'help']]
        ]
    });
    
    //목록
	$("#btnList").on("click", function(e){ 
		movePage("/ynm/study");
	});
	
	//저장
	$("#btnSave").on("click", function(e){ 
		if($("#btnSave").attr("newFlag") == 'true'){
			study.insertBoard();
		}else{
			study.updateBoard();
		}
	});
	
	//수정페이지로 이동
	$("#btnUpdate").on("click", function(e){ 
		var idx = $("#IDX").val()*1;
		movePage("/ynm/study/edit/"+idx);
	});
	
	//삭제
	$("#btnDelete").on("click", function(e){ 
		study.deleteBoard();
	});
	
	study = new studyEdit();	
});

function studyEdit() {
	this.init = function(){
		
	},
	this.insertBoard = function(){ 
		var data = {
			"TITLE": $("#TITLE").val(),
			"CONTENTS": $('#summernote').summernote('code')
		};
		$.ajax({
			type : "POST",                               
			url : "/ynm/study/insert",                   
			json : true,                           
			data : data,      
			async: false,
			success : function(result, textStatus, jqXHR){
				alert('성공적으로 저장되었습니다.');
				var idx = $("#IDX").val()*1;
				movePage("/ynm/study/view/"+idx);
			},
			error   : function(result, textStatus, jqXHR){
				console.log(result, textStatus, jqXHR);
				//movePage("/ynm");
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
				alert('성공적으로 수정되었습니다.');
				var idx = $("#IDX").val()*1;
				movePage("/ynm/study/view/"+idx);
			},
			error   : function(result, textStatus, jqXHR){
				movePage("/ynm/study");
			}
		});		
	},
	this.deleteBoard = function(){ 
		var data = {
			"IDX": $("#IDX").val()
		};
		$.ajax({
			type : "POST",                               
			url : "/ynm/study/delete",                   
			json : true,                           
			data : data,                 
			success : function(result, textStatus, jqXHR){
				alert('삭제되었습니다.');
				movePage("/ynm/study");
			},
			error   : function(result, textStatus, jqXHR){
				movePage("/ynm/study");
			}
		});		
	}
	
}
