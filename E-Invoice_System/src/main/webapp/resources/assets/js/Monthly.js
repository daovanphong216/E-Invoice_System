function forcessData(data, scale, list){
        retu ={
            cols: [
                      {"id":"","label":scale,"type":"string"},
                      {"id":"","label":"Money","type":"number"}
                    ],
            rows: []
          };
      var x=1;
      for(value in data){

        retu.rows.push({
          c : [{v:scale+" "+ x++}, {v:data[value]}]
        });
      
    }
    return retu;
    }


google.charts.load('current', { 'packages': ['corechart'] });
google.charts.setOnLoadCallback(drawChart);
function drawChart() {
    var linedata = new google.visualization.DataTable(forcessData([1,2,3,6,5,4]),"Month");
    var piedata = new google.visualization.DataTable(forcessData([1,2,3,6]),"Type");
    var options = { 'width': 550, 'height': 400,legend: 'none', colors: ['black','violet','orange', 'green', 'yellow', 'gray']
};
    document.getElementById('bar').addEventListener('click', function () {
    var barchart = new google.visualization.PieChart(document.getElementById('barchart'));
      barchart.draw(piedata, options);
      var linechart = new google.visualization.LineChart(document.getElementById('linechart'));
      linechart.draw(linedata, options);
    }, true);
   
  }