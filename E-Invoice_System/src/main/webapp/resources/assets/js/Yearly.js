function forcessdata(data){
      var months= ['January', 'February', 'March', 'April', 'May', 'June', 'July', 'August', 'September', 'October', 'November', 'December'];
        retu ={
            cols: [
                      {"id":"","label":"Month","type":"string"},
                      {"id":"","label":"Money","type":"number"}
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
    var data = new google.visualization.DataTable(forcessdata([1,2,3,6,5,4]));
    var options = { 'width': 550, 'height': 400 };
    document.getElementById('pie').addEventListener('click', function () {
      var piechart = new google.visualization.ColumnChart(document.getElementById('piechart'));
      piechart.draw(data, options);
    }, true);
  }