$(document).ready(function(){

	$('.invoiceform').submit(function(){
        alert("Submitted");
    });
	
	
	$(".invoiceform").validate({
		submitHandler: function(form) {
		    // some other code
		    // maybe disabling submit button
		    // then:
		    $('#CreateInvoiceFormModal').modal('hide');
		    form.reset();
		  }
	});

});