var invoicesdata;
var codein,int,indtime;
$(document).ready(function(){

	$.ajax({url: "http://localhost:8080/E-Invoice_System/getInvoiceFromUser", success: function(result){
			invoicesdata = result;
			listDataArray(invoicesdata);
			
    }});
	function listDataArray(data){
		$('.container .P-List-invoice .list-group').ready(function(){
    		for(var i = 0; i < data.length; i++){
    			codein = data[i].invoiceNo;
    			inty = data[i].type;
    			indtime = data[i].dateTime;
    			var markup = "<li class='list-group-item d-flex justify-content-between align-items-center borderless'>"+"<span class='i-circle align-self-center col-sm-4 col-lg-4 col-xs-4' id='detail'>"
    			+codein[0] 
    			+"</span><span class='align-self-center col-xs-9 col-lg-9 P-info-invoice' valign='center'><b style='font-size:20px'>"
    			+ codein
    			+"</b></br>"
    			+ inty
    			+ " | " +  indtime
    			+"</span>"
    			+"<span class='align-self-center col-xs-1 col-lg-1' valign='center'>"
    			+"<span class='glyphicon glyphicon-remove delete'/>"
    			+"</br>"
    			+"<span class='glyphicon glyphicon-edit edit'/>"
    			+"</span>" 
    			+"</li>";
    			$(".container .P-List-invoice .list-group").append(markup);
    		}
    	});
	}
	function detailInvoice(detailarray){
		
	}
});
