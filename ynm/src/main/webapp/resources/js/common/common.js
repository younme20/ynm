/**
 * 
 */
function movePage(url) {
	location.href = url;	
}

function ymDataObj() {
	this.ymDataObj = {};	
}

ymDataObj.prototype.addParam = function(dataObj) {
	
	this.ymDataObj.requestParam = $.extend(this.ymDataObj.requsetParam, dataObj);
}

function calendarEvent(eventData){
    var calendarEl = $("div[id=calendar]")[0];
	 var date = new Date();
	 var d = date.getDate();
	 var m = date.getMonth();
	 var y = date.getFullYear();
	 
    var calendar = new FullCalendar.Calendar(calendarEl, {
      locale: 'ko', //한글 
      headerToolbar: {
    	  start: 'prev,next',
    	  center: '',
    	  end : 'title'
      },
      //날짜 클릭 이벤트	
      dateClick: function (info) {
          //alert('Clicked on: ' + info.dateStr);
    	  //calendar.addEvent( {'title':'evt4', 'start':'2020-08-01', 'end':'2020-08-06'});
    	  $("#planModal").modal('show');
      },
      bootstrapFontAwesome: {
    	  close: 'fa-times',
    	  prev: 'fa-chevron-left',
    	  next: 'fa-chevron-right',
    	  prevYear: 'fa-angle-double-left',
    	  nextYear: 'fa-angle-double-right'
      },
      initialView: 'dayGridMonth',
      schedulerLicenseKey: 'GPL-My-Project-Is-Open-Source', //라이센스
	  editable: true,
	  navLinks: true, //달력상의 날짜를 클릭할 수 있는지 여부 
	  eventLimit: true, //달력 상에 셀 크기보다 많은 이벤트가 등록되어 있는 경우 more로 표시함
	  events: [
		{
			title : '예제 ',
			start : '2020-08-25',
			end: '2020-08-27'
		}  
	  ],
	  height: 500,
	  weight: 300,
	  handleWindowResize: true, //크기 자동 조정
      droppable: true, // this allows things to be dropped onto the calendar
      drop: function(info) {
        if (checkbox.checked) {
          info.draggedEl.parentNode.removeChild(info.draggedEl);
        }
      }
    });
    calendar.render();	
}


