
function ajaxsubmitcreate(data) {
    var str;
    $.ajax({
        url: "/E-Invoice_System/makeInvoice",
        type: 'GET',
        async: false,
        contentType: "application/json; charset=utf-8",
        dataType: "Json",
        processData: true,
        data: data,
        success: function (data) {
            str = data;
        },
        failure: function (data) {
            alert("Fail " + data);
        }

    });
    return str;
}

function getSelectedDateString(selectedDay){
	var sdd= selectedDay.getDate();
	if (sdd <10){
		sdd = '0'+sdd;
	}
	var sdm= selectedDay.getMonth()+1;
	if (sdm <10){
		sdm = '0'+sdm;
	}
	var sdy= selectedDay.getFullYear();
	
	return datestr = sdy+'-'+sdm+'-'+sdd;
}

$(document).ready(function(){
		
	console.log(getSelectedDateString(selectedDay));
	
	$( "input[name=dateTime]" ).val(getSelectedDateString(selectedDay));
	
	$('.create-button').click(function(){
		if($(".invoiceform").valid()){
		
		data = {};
		data.customerCode= $( "input[name=customerCode]" ).val();
		data.invoiceNo= $( "input[name=invoiceNo]" ).val();
		data.dateTime= $( "input[name=dateTime]" ).val();
		data.amountOfMoney= $( "input[name=amountOfMoney]" ).val();
		data.description= $( "input[name=description]" ).val();
		data.VAT= $( "input[name=VAT]" ).val();
	
		item = ajaxsubmitcreate(data);
		var returnedDay = new Date(item.dateTime);
		console.log(selectedDay);
		console.log(returnedDay);
		if((selectedDay.getDate() == returnedDay.getDate()) && (selectedDay.getFullYear() == returnedDay.getFullYear())&& (selectedDay.getMonth() == returnedDay.getMonth())){
			updateItemToViewList(item);
		}
			
			
		

		$(".invoiceform")[0].reset();
		$( "input[name=dateTime]" ).val(getSelectedDateString(selectedDay));
		$('#CreateInvoiceFormModal').modal('hide');
		}
		
	});

});