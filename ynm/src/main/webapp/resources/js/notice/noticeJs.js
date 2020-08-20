$(document).ready(function(){
	$("#modifyFrom").on("click", function(){
		alert('수정폼 이동');
		movePage("/ynm/modifyForm");

	});

	$("#delete").on("click", function(){
		alert('삭제 이동');
		movePage("/ynm/noticeDelete");

	});

	$("#list").on("click", function(){
		alert('목록 이동');
		movePage("/ynm/notice");

	});

});


/*//목록
function fn_list(){
    
    var form = document.getElementById("writeForm");
    
    form.action = "<c:url value='/notice'/>";
    form.submit();
    
}

 
//수정
function fn_modify(){
    
    var form = document.getElementById("writeForm");
    
    form.action = "<c:url value='/modifyForm'/>";
    form.submit();
}

//삭제
function fn_delete(){
    
    var form = document.getElementById("writeForm");
    
    form.action = "<c:url value='/noticeDelete'/>";
    form.submit();
}
//새글 등록
function fn_insert(){
    
    var form = document.getElementById("writeForm");
    
    form.action = "<c:url value='/noticeInsert'/>";
    form.submit();
}*/