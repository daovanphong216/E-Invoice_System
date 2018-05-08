function getSolutionjson() {
    var str;
    $.ajax({
        url: "http://localhost:8080/E-Invoice_System/getInvoiceFromUser",
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



$(document).ready(function(){
	invoicesdata = getSolutionjson();
	console.log(invoicesdata);
	
	
	

});
var app = angular.module('myApp', []);
app.controller('customersCtrl', function($scope) {
	$scope.table = getSolutionjson();
	$scope.removeElem = function(e){
		console.log(e);
		$scope.table.splice($scope.table.indexOf(e), 1);
		
		
		
		
	};
});
