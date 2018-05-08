var invoicesdata;

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


function listDataArray(data){
	$('.page-container').append('haha');
};




$(document).ready(function(){
	invoicesdata = getSolutionjson();
	listDataArray(invoicesdata);
	console.log(invoicesdata);
});
