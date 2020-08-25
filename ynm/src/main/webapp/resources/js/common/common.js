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
      //plugins : [ 'interaction', 'dayGrid' ], //월 캘린더  
      //날짜 클릭 이벤트	
      dateClick: function (info) {
          alert('Clicked on: ' + info.dateStr);
      },
      initialView: 'dayGridMonth',
      schedulerLicenseKey: 'GPL-My-Project-Is-Open-Source', //라이센스
	  editable: true,
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


