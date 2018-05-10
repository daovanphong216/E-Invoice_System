    
    // Draw the chart and set the chart values
    function drawPieChart() {
      var pieData = $.ajax({
        url: "piechartData.json",
        dataType: "json",
        async: false
      }).responseText;
      console.log(pieData);
      var data = new google.visualization.DataTable(pieData);
      // Optional; add a title and set the width and height of the chart
      var options = { 'width': 550, 'height': 400 };
      // Display the chart inside the <div> element with id="piechart"
      //https://developers.google.com/chart/interactive/docs/gallery chart types
      document.getElementById('left').addEventListener('click', function () {
        //$("#barchart").empty();
        var piechart = new google.visualization.PieChart(document.getElementById('piechart'));
        piechart.draw(data, options);
      }, true);
      document.getElementById('pie').addEventListener('dblclick', function () {
        $("#piechart").empty();
      }, true);
    }
