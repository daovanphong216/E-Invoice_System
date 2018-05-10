function getInvoicejsonByDate(dateStr) {
    var str;
    $.ajax({
        url: "http://localhost:8080/E-Invoice_System/getInvoiceFromUser/" + dateStr,
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
}


function removeinvoice(dateStr) {
    var str;
    $.ajax({
        url: "http://localhost:8080/E-Invoice_System/removeinvoice/" + dateStr,
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
}





$(document).ready(function () {


    //----------------------------------------------------------------------




    function listDataArray(data) {
        var noValue;
        var spendingmoney;




        $('.removeItem').click(function () {

            var index = this.getAttribute("item-id");
            var item = `[item-div-id=${index}]`
            $(item).remove();
            removeinvoice(index);
            console.log(index);

        });


    };


    //-------------------------------------------------------------------------
    //Draw Monthly chart
    google.charts.load('current', { 'packages': ['corechart'] });
    google.charts.setOnLoadCallback(drawChart);
    function drawChart() {
        var barData = $.ajax({
            url: "barchartData.json/",
            dataType: "json",
            async: false
        }).responseText;
        var bardata = new google.visualization.DataTable(barData);
        // Optional; add a title and set the width and height of the chart
        var options = { 'width': 550, 'height': 400 };
        // Display the chart inside the <div> element with id="piechart"
        //https://developers.google.com/chart/interactive/docs/gallery chart types
        document.getElementById('left').addEventListener('click', function () {
            var barchart = new google.visualization.ColumnChart(document.getElementById('barchart'));
            barchart.draw(bardata, options);
        }, true);

    }



    var currentDate = new Date();
    selectedDay = currentDate;
    $('.selectedView').html(selectedDay);

    function generateList(sd) {
        //    	var sdd= sd.getDate();
        //    	var sdm= sd.getMonth()+1;
        //    	var sdy= sd.getFullYear();
        //    	
        //    	var datestr = sdy+'-'+sdm+'-'+sdd;

        var datestr = getSelectedDateString(sd)

        jsonData = getInvoicejsonByDate(datestr);
        $('.selectedView').html(jsonData);

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
            weekDays: ['Su', 'Mon', 'Tue', 'Wed', 'Thu', 'Fri', 'Sat'],
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
                        cal[i].push('<td class="day"><a class="dlink" href="#" dd="' + day++ + '" mm="' + d.getMonth() + '" yy="' + d.getFullYear() + '">' + (day - 1) + '</a></td>');
                    }
                }
            }
            cal[i].push('</tr>');

        }
        cal = cal.reduce(function (a, b) {
            return a.concat(b);
        }, []).join('');
        //$('table').append(cal);
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
            generateList(selectedDay);
            $("input[name=dateTime]").val(getSelectedDateString(selectedDay));
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
        drawChart();

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


})