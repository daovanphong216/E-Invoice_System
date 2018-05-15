
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
			
	$( "input[name=dateTime]" ).val(getSelectedDateString(selectedDay));
	
	//-----------------------------------
	function showType(){
		$("#typeSelect" ).empty();
		var typesJson = getAllTypesjson(getSelectedDateString(selectedDay));
		for(var type in typesJson){
			var markup = `<option value="${typesJson[type].id}">${typesJson[type].name}</option>`;
			$(".typeSelect" ).append(markup);
		}
	}
	showType();
	
	//-----------------------------------
	function showTypeDelete(){
		var typesJson = getAllTypesjson(getSelectedDateString(selectedDay));
		$("#delete_type" ).empty();
		for(var type in typesJson){
			if (typesJson[type].deleteAble==false){
			var markup = `<option value="${typesJson[type].id}">${typesJson[type].name}</option>`;
			$("#delete_type" ).append(markup);
			}
		}
	}
	
	 showTypeDelete();
	 
	$('.create-button').click(function(){
		if($(".invoiceform").valid()){
		
		fdata = {};
		fdata.customerCode= $( "input[name=customerCode]" ).val();
		fdata.invoiceNo= $( "input[name=invoiceNo]" ).val();
		fdata.dateTime= $( "input[name=dateTime]" ).val();
		fdata.amountOfMoney= $( "input[name=amountOfMoney]" ).val();
		fdata.description= $( "input[name=description]" ).val();
		fdata.VAT= $( "input[name=VAT]" ).val();
		fdata.type= $("select[name=type]" ).val();

	
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
		$( "input[name=dateTime]" ).val(getSelectedDateString(selectedDay));
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