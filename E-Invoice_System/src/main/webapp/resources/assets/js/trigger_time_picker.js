$(document).ready(function(){
	$("#time_submit").on('click', function() {
		   checkData();
		});
	
	
	function sendTrigger(day, time){
		$.ajax({
			type : "POST",
			url : "/E-Invoice_System/updateTrigger",
			data : {
				'day' : day,
				'time' : time
			},
			dataType : "json",
			success : function(data) {
				$('#timeModal').modal('hide');
				$('#input-time').val("Day " + day +" at " +time);
				
			}
		});
	}
	
	function checkData(){
		var time= $("#time").val();
		if (time!= "") {
			var day = $("#day").val();
			sendTrigger(day, time);
		}
		/*if (isEmail(email)){
			var password = $('#password').val();
			var password_confirm = $('#password_confirm').val();
			if (password == password_confirm){
				var name = $("#name").val();
				var address = $("#address").val();
				var phoneNumber = $("#telNo").val();
				var username = $("#username").val();
				changeInfo(username, password, email, name, address, phoneNumber);
			}
			
		}*/
		
	}
});