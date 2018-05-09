function getInvoicejsonByDate(dateStr) {
    var str;
    $.ajax({
        url: "http://localhost:8080/E-Invoice_System/getInvoiceFromUser/"+dateStr,
        type: 'GET',
        async: false,
        contentType: "application/json; charset=utf-8",
        dataType: "json",
        processData: true,
        success: function (data) {
            str = data;
        },
        failure: function (data) {
            alert("Fail " + data);
        }

    });
    return str;
};


$(document).ready(function () {
    var currentDate = new Date();
    selectedDay = currentDate;
    $('.selectedView').html(selectedDay);
   // generateList(selectedDay);
    
    function generateList(sd){
    	var sdd= sd.getDate();
    	var sdm= sd.getMonth()+1;
    	var sdy= sd.getFullYear();
    	
    	var datestr = sdy+'-'+sdm+'-'+sdd;
    	
    	jsonData = getInvoicejsonByDate(datestr);
    	$('.selectedView').html(jsonData);
    	console.log(jsonData);
    	
    };
    
    
    function generateCalendar(d) {
        function monthDays(month, year) {
            var result = [];
            var days = new Date(year, month, 0).getDate();
            for (var i = 1; i <= days; i++) {
                result.push(i);
            }
            return result;
        }
        Date.prototype.monthDays = function () {
            var d = new Date(this.getFullYear(), this.getMonth() + 1, 0);
            return d.getDate();
        };
        var details = {
            // totalDays: monthDays(d.getMonth(), d.getFullYear()),
            totalDays: d.monthDays(),
            weekDays: ['Sunday', 'Monday', 'Tuesday', 'Wednesday', 'Thursday', 'Friday', 'Saturday'],
            months: ['January', 'February', 'March', 'April', 'May', 'June', 'July', 'August', 'September', 'October', 'November', 'December'],
        };
        var start = new Date(d.getFullYear(), d.getMonth()).getDay();
        var cal = [];
        var day = 1;
        for (var i = 0; i <= 6; i++) {
            cal.push(['<tr>']);
            for (var j = 0; j < 7; j++) {
                if (i === 0) {
                    cal[i].push('<td>' + details.weekDays[j] + '</td>');
                } else if (day > details.totalDays) {
                    cal[i].push('<td>&nbsp;</td>');
                } else {
                    if (i === 1 && j < start) {
                        cal[i].push('<td>&nbsp;</td>');
                    } else {
                        cal[i].push('<td class="day"><a class="dlink" href="#" dd="'+ day++ +'" mm="'+ d.getMonth() +'" yy="'+ d.getFullYear() +'">' + (day-1) + '</a></td>');
                    }
                }
            }
            cal[i].push('</tr>');
        }
        cal = cal.reduce(function (a, b) {
            return a.concat(b);
        }, []).join('');
        $('table').append(cal);
        $('#month').text(details.months[d.getMonth()]);
        $('#year').text(d.getFullYear());
        $('td.day').mouseover(function () {
            $(this).addClass('hover');
        }).mouseout(function () {
            $(this).removeClass('hover');
        });
        $('.dlink').click(function () {
            selectedDay.setDate(this.getAttribute("dd"));
            selectedDay.setMonth(this.getAttribute("mm"));
            selectedDay.setFullYear(this.getAttribute("yy"));
            $('.selectedView').html(selectedDay);
         //   generateList(selectedDay);
        });
    }
    $('#left').click(function () {
        $('table').text('');
        if (currentDate.getMonth() === 0) {
            currentDate = new Date(currentDate.getFullYear() - 1, 11);
            generateCalendar(currentDate);
        } else {
            currentDate = new Date(currentDate.getFullYear(), currentDate.getMonth() - 1)
            generateCalendar(currentDate);
        }
    });
    $('#right').click(function () {
        $('table').html('<tr></tr>');
        if (currentDate.getMonth() === 11) {
            currentDate = new Date(currentDate.getFullYear() + 1, 0);
            generateCalendar(currentDate);
        } else {
            currentDate = new Date(currentDate.getFullYear(), currentDate.getMonth() + 1)
            generateCalendar(currentDate);
        }
    });
    generateCalendar(currentDate);
    
    
});