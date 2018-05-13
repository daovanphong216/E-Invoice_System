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

function getTypeReportjson(Str) {
    var str;
    $.ajax({
        url: "/E-Invoice_System/gettypereport/"+Str,
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

function forcessDataT(data){
        retu ={
            cols: [
                      {"id":"","label":"Type","type":"string"},
                      {"id":"","label":"Money","type":"number"}
                    ],
            rows: []
          };
      var x=1;
      for(value in data){

        retu.rows.push({
          c : [{v:value}, {v:data[value]}]
        });
      
    }
    return retu;
    }
function forcessDataD(data){
    retu ={
        cols: [
                  {"id":"","label":"Date","type":"number"},
                  {"id":"","label":"Money","type":"number"},
                  {"id":"","label":"Limit Money","type":"number"}
                ],
        rows: []
      };
  var x=1;
  var total = 0.0;
  for(value in data){
	  total+=data[value];
    retu.rows.push({
      c : [{v:value}, {v:total}, {v: 200}]
    });
  
}
return retu;
}
months= ['January', 'February', 'March', 'April', 'May', 'June', 'July', 'August', 'September', 'October', 'November', 'December'];

google.charts.load('current', { 'packages': ['corechart'] });
google.charts.setOnLoadCallback(drawChart);
function drawChart() {
    
    $("document").ready(function() {
    	year = new Date().getFullYear();
    	$('#year').html(year);
    	month = new Date().getMonth()
    	$('#month').html(months[month]);
    	datajs = getReportjson(year+'/'+(month+1)); 
    	typedatajs = getTypeReportjson(year+'/'+(month+1));
    	var linedata = new google.visualization.DataTable(forcessDataD([0.0,...datajs]));
        var piedata = new google.visualization.DataTable(forcessDataT(typedatajs,months));
        var options = { 'width': 550, 'height': 400, curveType: 'function'};
    	
    var barchart = new google.visualization.PieChart(document.getElementById('barchart'));
      barchart.draw(piedata, options);
      var linechart = new google.visualization.LineChart(document.getElementById('linechart'));
      linechart.draw(linedata, options);
    });
   
  }