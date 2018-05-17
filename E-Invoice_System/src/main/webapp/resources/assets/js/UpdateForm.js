
function ajaxsubmitupdate(data, id) {
    var str;
    $.ajax({
        url: "/E-Invoice_System/updateInvoice/"+id,
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

$(document).ready(function(){
	$('.update-invoice-button').click(function(){
		
		udata = {};
		udata.customerCode= $( "input[name=ucustomerCode]" ).val();
		udata.invoiceNo= $( "input[name=uinvoiceNo]" ).val();
		udata.dateTime= $( "input[name=udateTime]" ).val();
		udata.amountOfMoney= $( "input[name=uamountOfMoney]" ).val();
		udata.description= $( "input[name=udescription]" ).val();
		udata.VAT= $( "input[name=uVAT]" ).val();

		item = ajaxsubmitupdate(udata,indexToUpdate);
		
		alert('updated');
		
	});
});