var invoicesdata;
$(document).ready(function(){
		$.ajax({url: "http://localhost:8080/E-Invoice_System/getInvoiceFromUser", success: function(result){
			invoicesdata = result;
        }});
        
        
    $("button").click(function(){
    	console.log(invoicesdata);
    });
});