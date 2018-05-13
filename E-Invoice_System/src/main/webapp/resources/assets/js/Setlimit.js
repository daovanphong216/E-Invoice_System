function ajaxsunmitlimit(data) {
    var str;
    $.ajax({
        url: "/E-Invoice_System/setlimitmoney",
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
	$('.update-limit-button').click(function(){
		if($(".limitform").valid()){
		
		data = {};
		
		data.amountOfMoney= $( "input[name=limitMoney]" ).val();
		

	
		var stt = ajaxsunmitlimit(data);
		


		$(".limitform")[0].reset();
		$('#SetLimitMonneyModal').modal('hide');
		}
		$.get("/E-Invoice_System/getlimitmoney", function(data, status){
			$('.limitedMoney').html(data);
	    });
		
	});
	
	$.get("/E-Invoice_System/getlimitmoney", function(data, status){
		$('.limitedMoney').html(data);
    });
	
	
});