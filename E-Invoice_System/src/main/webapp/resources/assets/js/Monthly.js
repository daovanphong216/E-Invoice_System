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

function getlimit() {
    var str;
    $.ajax({
        url: "/E-Invoice_System/getlimitmoney",
        type: 'GET',
        async: false,
        contentType: "application/json; charset=utf-8",
        dataType: "text",
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
	var limitmn=getlimit();
    retu ={
        cols: [
                  {"id":"","label":"Date","type":"string"},
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
      c : [{v:value+' '}, {v:total}, {v: limitmn}]
    });
  
}
return retu;
}
months= ['January', 'February', 'March', 'April', 'May', 'June', 'July', 'August', 'September', 'October', 'November', 'December'];

google.charts.load('current', { 'packages': ['corechart'] });
google.charts.setOnLoadCallback(drawChart);

function drawChart() {
    
    $("document").ready(function() {
    
    	var year = new Date().getFullYear();
    	var month = new Date().getMonth();
    
    	if (month<10){
    		var mstr = year+'-0'+(month+1);
    	}else{
    		var mstr = year+'-'+(month+1);
    	}
    	
    	$('input[name=mmonth]').val(mstr);
    	datajs = getReportjson(year+'/'+(month+1)); 
    	typedatajs = getTypeReportjson(year+'/'+(month+1));
    	var linedata = new google.visualization.DataTable(forcessDataD([0.0,...datajs]));
        var piedata = new google.visualization.DataTable(forcessDataT(typedatajs,months));
        var options = { 'width': 1000, 'height': 656, curveType: 'function'};
    	
        var barchart = new google.visualization.PieChart(document.getElementById('barchart'));
        barchart.draw(piedata, options);
        var linechart = new google.visualization.LineChart(document.getElementById('linechart'));
        linechart.draw(linedata, options);
      
        
        $('input[name=mmonth]').change(function(){
        	
         	datajs = getReportjson($('input[name=mmonth]').val().replace("-", "/")); 
         	
       	typedatajs = getTypeReportjson($('input[name=mmonth]').val().replace("-", "/"));
       	var linedata = new google.visualization.DataTable(forcessDataD([0.0,...datajs]));
           var piedata = new google.visualization.DataTable(forcessDataT(typedatajs,months));
         	var barchart = new google.visualization.PieChart(document.getElementById('barchart'));
           barchart.draw(piedata, options);
           var linechart = new google.visualization.LineChart(document.getElementById('linechart'));
           linechart.draw(linedata, options);
        });
        
        
        $.ajax({
	        url: "/E-Invoice_System/getAllTypesByUser",
	        type: 'GET',
	        async: false,
	        contentType: "application/json; charset=utf-8",
	        dataType: "json",
	        processData: true,
	        success: function (data) {
	        	$("#select-option" ).empty();
	        	$("#select-option" ).append("<option value='0'>All</option>");
	    		$("#delete_type" ).empty();
	    		for(var type in data){
	    			var markup = `<option value="${data[type].id}">${data[type].name}</option>`;
	    			$("#select-option" ).append(markup);
	    			if (data[type].deleteAble==true){
	    				markup = `<option value="${data[type].id}">${data[type].name}</option>`;
	    				$("#delete_type" ).append(markup);
	    				}
	    		}
	        },
	        failure: function (data) {
	            alert("Fail " + data);
	        }

	    });
      
    });
   
  }