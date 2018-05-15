
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
	console.log(selectedDay);
	var sdd= selectedDay.getDate();
	if (sdd <10){
		sdd = '0'+sdd;
	}
	var sdm= selectedDay.getMonth()+1;
	if (sdm <10){
		sdm = '0'+sdm;
	}
	var sdy= selectedDay.getFullYear();
	
	var datestr = sdy+'-'+sdm+'-'+sdd;
	console.log(datestr);
	return datestr;
}

$(document).ready(function(){
			
	$( "input[name=dateTimeInCreateForm]" ).val(getSelectedDateString(selectedDay));
	
	//-----------------------------------
	
	 
	$('.create-button').click(function(){
		if($(".invoiceform").valid()){
		
		fdata = {};
		fdata.customerCode= $( "input[name=customerCodeInCreateForm]" ).val();
		fdata.invoiceNo= $( "input[name=invoiceNoInCreateForm]" ).val();
		fdata.dateTime= $( "input[name=dateTimeInCreateForm]" ).val();
		fdata.amountOfMoney= $( "input[name=amountOfMoneyInCreateForm]" ).val();
		fdata.description= $( "input[name=descriptionInCreateForm]" ).val();
		fdata.VAT= $( "input[name=VATInCreateForm]" ).val();
		fdata.type= $("select[name=typeInCreateForm]" ).val();

	fdata.customerCode="1111";
		item = ajaxsubmitcreate(fdata);
		var returnedDay = new Date(item.dateTime);
		if((selectedDay.getDate() == returnedDay.getDate()) && (selectedDay.getFullYear() == returnedDay.getFullYear())&& (selectedDay.getMonth() == returnedDay.getMonth())){
			updateItemToViewList(item,fdata.type);
			$.get("/E-Invoice_System/gettypereport/"+selectedDay.getFullYear()+"/"+(selectedDay.getMonth()+1)+"/"+selectedDay.getDate(), function(data, status){
        		for(i in data){
        			$('.'+data[i].name+'no').html(data[i].noOfInvoice);
        			$('.'+data[i].name+'money').html(data[i].totalMonney);
        		}      		
            });
			
			
			$.get("/E-Invoice_System/getreport/"+selectedDay.getFullYear()+"/"+(selectedDay.getMonth()+1), function(data, status){
				$('.totalDateMoney').html(data[selectedDay.getDate()-1]);
		    });
		}
			
			
		

		$(".invoiceform")[0].reset();
		$( "input[name=dateTimeInCreateForm]" ).val(getSelectedDateString(selectedDay));
		$('#CreateInvoiceFormModal').modal('hide');
		
		
		if((selectedDay.getFullYear() == returnedDay.getFullYear())&& (selectedDay.getMonth() == returnedDay.getMonth())){

		var year = selectedDay.getFullYear();
		$.get("/E-Invoice_System/getreport/"+year, function(data, status){
			$('.totalMonthMoney').html(data[selectedDay.getMonth()]);
	    });
		}
		
		}
		
	});
	
	var year = selectedDay.getFullYear();
	$.get("/E-Invoice_System/getreport/"+year, function(data, status){
		$('.totalMonthMoney').html(data[selectedDay.getMonth()]);
    });
	
	$.get("/E-Invoice_System/getreport/"+year+"/"+(selectedDay.getMonth()+1), function(data, status){
		$('.totalDateMoney').html(data[selectedDay.getDate()-1]);
    });
	
	$.get("/E-Invoice_System/gettypereport/"+year+"/"+(selectedDay.getMonth()+1)+"/"+selectedDay.getDate(), function(data, status){
		for(i in data){
			$('.'+data[i].name+'no').html(data[i].noOfInvoice);
			$('.'+data[i].name+'money').html(data[i].totalMonney);
		}
		
    });
	

	
	
	
});