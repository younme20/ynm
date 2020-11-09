/**
 * 일정관리 공통
 */
const all = false;

$(document).ready(function(){
	$("select[name='COLOR']").trigger("change");

	selectSchedule(all);

	//datetimepicker
	$("#startDate").datetimepicker({
		format:'YY/MM/DD hh:mm',
		sideBySide: true,
	});
	
	$("#endDate").datetimepicker({
		format:'YY/MM/DD hh:mm',
		sideBySide: true,
		useCurrent: false
	});

    $("#startDate").on("dp.change", function (e) {
        $('#END_DATE').data("DateTimePicker").minDate(e.date);
    });
    $("#endDate").on("dp.change", function (e) {
        $('#START_DATE').data("DateTimePicker").maxDate(e.date);
    });

	$("#startDate").focus(function(){
		$(this).datetimepicker("show");
	});

	$("#startDate").blur(function(){
		$(this).datetimepicker("hide");
	});

	$("#endDate").focus(function(){
		$(this).datetimepicker("show");
	});

	$("#endDate").blur(function(){
		$(this).datetimepicker("hide");
	});

	
	$("#btnModalConfirm").on("click", function(e){
		saveSchedule();
	});	
	
	$("#btnModalDelete").on("click", function(e){
		deleteSchedule();
	});

});

function selectSchedule(all) {
	var token = $("meta[name='_csrf']").attr("content");
	var header = $("meta[name='_csrf_header']").attr("content");

	$.ajax({
		type : "POST",                               
		url : "/ynm/schedule/list",                   
		json : true,
		data : {"all" : all},//JSON.stringify({"_csrf":token}),
		beforeSend: function(xhr) {
			//xhr.setRequestHeader(header,token);
		},
		success : function(result, textStatus, jqXHR){
			calendarEvent(result);
		},
		error   : function(result, textStatus, jqXHR){
			console.log(result, textStatus, jqXHR);
		}
	});		
}

function saveSchedule() {
	var schedule = $("#scheduleForm").serializeObject();
	
	var url = "";
	if(schedule["IDX"] == ""){
		url = "insert";
	}else{
		url = "update";
	}

	$.ajax({
		type : "POST",                               
		url : "/ynm/schedule/"+url,                   
		json : true,                           
		data : schedule,      
		success : function(result, textStatus, jqXHR){
			alert('성공적으로 저장되었습니다.');
			calendarEvent(result);
		},
		error   : function(result, textStatus, jqXHR){
			console.log(result, textStatus, jqXHR);
		}
	});			
}

function deleteSchedule() {
	var schedule = $("#scheduleForm").serializeObject();
	$.ajax({
		type : "POST",
		url : "/ynm/schedule/delete",                   
		json : true,                           
		data : schedule,      
		success : function(result, textStatus, jqXHR){
			alert('성공적으로 삭제되었습니다.');
			calendarEvent(result);	
		},
		error   : function(result, textStatus, jqXHR){
			console.log(result, textStatus, jqXHR);
		}
	});			
}



function calendarEvent(eventData){	
    var calendarEl = $("div[id=calendar]")[0];
	var date = new Date();
	var d = date.getDate();
	var m = date.getMonth();
	var y = date.getFullYear();	
	
    var calendar = new FullCalendar.Calendar(calendarEl, {
    	themeSystem: 'bootstrap',
		locale: 'ko', //한글
      timezone: "local",
      allDaySlot: true,
      timeFormat: 'HH:mm',
      minTime: '00:00',
      maxTime: '24:00',
      headerToolbar: {
    	  start: 'allViewButton,prev,next',
    	  center: 'title',
		  end: 'dayGridMonth,timeGridWeek,timeGridDay'
	  },
		customButtons: {
			allViewButton: {
				text: '모두 보기',
				click: function() {
					selectSchedule(true);
				}
			}
		},
		buttonText: {
    		prev : '이전',
			next : '다음',
			dayGridMonth : '월',
			timeGridWeek: '주',
			timeGridDay: '일'
		},
      //height: 1200,
      //날짜 클릭 이벤트
      dateClick: function (info) {
    	  $("#scheduleForm")
			  .find(':radio, :checkbox').removeAttr('checked').end()
			  .find('textarea,:hidden,:text, select').val('');

		  $("#START_DATE").val(moment(info.date).format('YY/MM/DD hh:mm'));
		  $("#planModal").modal('show');
      },
      eventClick: function(info) {
    	  let eventFullDate = info.event.start;
    	  
    	  let eventYear = eventFullDate.getFullYear() // 선택된 이벤트 연도
    	  let eventMonth = eventFullDate.getMonth() + 1; // 선택된 이벤트 월
    	  let eventDate = eventFullDate.getDate(); // 선택된 이벤트 일
    	  let eventDay = eventFullDate.getDay(); // 선택된 이벤트 요일    	  
    	  
    	  // 해당 이벤트 정보 가져오기 -> 나중에 위의 함수랑 합치기
    	  $.ajax({
    	    url: "/ynm/schedule/list",    
    	    type: "POST",
    	    data: {IDX : info.event._def.extendedProps.idx},
    		json : true,                           
    		success : function(result, textStatus, jqXHR){
    	      if (result.length > 0) {
    	    	  $.each(result[0], function(id, value){
    	    		  $("#"+id.toUpperCase()).val(value);
    	    	  });
    	    	  $("#planModal").modal('show');
    	      } else {
    	      	// 이벤트 목록 없을 때
    	      }
    	    },
    		error   : function(result, textStatus, jqXHR){
    			console.log(result, textStatus, jqXHR);
    		}
    	  });
      },
      contentHeight: "auto",
      initialView: 'dayGridMonth',
      schedulerLicenseKey: 'GPL-My-Project-Is-Open-Source', //라이센스
	  editable: true,
	  navLinks: false, //달력상의 날짜를 클릭할 수 있는지 여부 
	  eventLimit: true, //달력 상에 셀 크기보다 많은 이벤트가 등록되어 있는 경우 more로 표시함
	  events: eventData, //	title, start, end
	  handleWindowResize: true, //크기 자동 조정
      droppable: true, //this allows things to be dropped onto the calendar
      drop: function(info) {
        if (checkbox.checked) {
          info.draggedEl.parentNode.removeChild(info.draggedEl);
        }
      }
    });
    calendar.render();	
}