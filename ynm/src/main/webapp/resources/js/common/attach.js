/**
 * 파일업로드.js
 */
$(document).ready(function(){
	
	$("#uploadFile").on({
		change: function () {
			attach.uploadFile();
		}
	});
	$("#uploadScope")
	.on("dragover", dragOver)
	.on("dragleave", dragOver)
	.on("drop", uploadFilesCheck);

	//drag 영역 클릭시 파일 선택창
	$("#uploadScope").on('click',function (e){
		$("#uploadFile").trigger('click');
    });
    
	// 파일삭제
	$(document).on("click", "#deleteFile", function(e){
		var file_no = $(this).attr("data");
		if (confirm("정말 삭제하시겠습니까??") == true){  
			attach.deleteFile(file_no);
		}else{   
		    return;
		}

	});
	
	// 다운로드
	$(".download").on("click", function(e){
		var file_no = $(this).attr("data");
		 window.location ="/ynm/attach/download?file_no="+file_no;
	});
	
	attach = new attach();
	
});

function attach() {
	this.init = function(){
		
	},
	this.uploadFile = function(file){
		var formData = new FormData($('#form1')[0]);
		formData.append('uploadFile', file);
	
		$.ajax({
			type : "POST",         
			enctype: 'multipart/form-data',
			url : "/ynm/attach/upload",
			data: formData, 
			processData: false,  
			contentType: false,  
			cache: false, 
			success : selectFileList,
			error   : function(result, textStatus, jqXHR){
				alert('업로드 실패!');
				console.log("code:"+result.status+"\n"+"message:"+result.responseText+"\n"+"error:"+textStatus);
	
			}
		});
	},
	this.deleteFile = function(file_no){ 
		var formData = {
			"FILE_GROUP":$("#FILE_GROUP").val()
			,"FILE_NO": file_no
		};
		$.ajax({
			type : "POST",                               
			url : "/ynm/attach/delete",                   
			json : true,                           
			data : formData,                 
			success : selectFileList,
			error   : function(result, textStatus, jqXHR){
				alert('삭제 실패');
			}
		});		
	},
	this.downloadFile = function(file_no){ 
		var formData = {
				"FILE_NO": file_no
			};
		$.ajax({
			type : "POST",                               
			url : "/ynm/attach/download",
			data: formData, 
			download: {
		        mimetype: "image/jpeg",
		        filename: "test",
		        data: "base64"
		    },
			cache: false, 
			json:true,
			success : function(result, textStatus, jqXHR){
				alert("다운로드 성공");
			},
			error   : function(result, textStatus, jqXHR){
				alert("다운로드 실패");
			}
		});
	}
}

	var selectFileList = function(data, resul){
		var fg = $("#FILE_GROUP").val();
		var num = "";
		$('#fileList div').remove();
		$.each(data, function(i, item) {
			$('#fileList').append("<div>"+ item.ORG_FILE_NAME + "<span>"+item.FILE_SIZE+" byte</span><button type='button' id='deleteFile' class='btn btn btn-warning' data="+item.FILE_NO+">삭제</button></div>");
			num = item.FILE_GROUP;
			
		});
		if(fg == "" || fg == null){
			$("#FILE_GROUP").val(num);
		 }
	}

	var dragOver = function(e){
	
	  e.stopPropagation();
	  e.preventDefault();
	  
	  if (e.type == "dragover") {
		  $(e.target).css({
	          "background-color": "black",
	          "outline-offset": "-20px"
	      });
	  } else {
	      $(e.target).css({
	          "background-color": "gray",
	          "outline-offset": "-10px"
	      });
	  }
	}
		 
	var uploadFilesCheck = function(e){
	  e.stopPropagation();
	  e.preventDefault();
	  dragOver(e);
	  
	  e.dataTransfer = e.originalEvent.dataTransfer;
	  var files = e.target.files || e.dataTransfer.files;
	  
      
	  if (files.length > 1) {
	      alert('한 개씩 업로드 해주세요');
	      return false;
	  }else{
		  
		  var file = e.originalEvent.dataTransfer.files;
	      attach.uploadFile(file[0]);
	  }
	  
	}