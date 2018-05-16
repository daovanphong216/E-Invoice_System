function getReportjson(Str) {
    var str;
    $.ajax({
        url: "/E-Invoice_System/getreport/"+Str,
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
function forcessdata(data){
      var months= ['January', 'February', 'March', 'April', 'May', 'June', 'July', 'August', 'September', 'October', 'November', 'December'];
        retu ={
            cols: [
                      {"id":"","label":"Month","type":"string"},
                      {"id":"","label":"Dolar","type":"number"}
                    ],
            rows: []
          };
      for(value in data){

        retu.rows.push({
          c : [{v:months[value]}, {v:data[value]}]
        });
      
    }
    return retu;
    }

google.charts.load('current', { 'packages': ['corechart'] });
google.charts.setOnLoadCallback(drawPieChart);
function drawPieChart() {
    
    var options = { 'width': 1050, 'height': 900 };
    $("document").ready(function() {
    	yyear = new Date().getFullYear();
    	$('#yyear').html(yyear);
    	var data = new google.visualization.DataTable(forcessdata(getReportjson(yyear)));
    	var piechart = new google.visualization.ColumnChart(document.getElementById('piechart'));
    	piechart.draw(data, options);
    });
    $('#yleft').click(function(){
    	yyear--;
    	$('#yyear').html(yyear);
    	var data = new google.visualization.DataTable(forcessdata(getReportjson(yyear)));
    	var piechart = new google.visualization.ColumnChart(document.getElementById('piechart'));
    	piechart.draw(data, options);
    });
    $('#yright').click(function(){
    	yyear++;
    	$('#yyear').html(yyear);
    	var data = new google.visualization.DataTable(forcessdata(getReportjson(yyear)));
    	var piechart = new google.visualization.ColumnChart(document.getElementById('piechart'));
    	piechart.draw(data, options);
    });
  }	
