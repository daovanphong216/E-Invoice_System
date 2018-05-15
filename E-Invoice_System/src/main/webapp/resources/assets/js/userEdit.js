$(document).ready(function(){

	function isEmail(email) {
		  var regex = /^([a-zA-Z0-9_.+-])+\@(([a-zA-Z0-9-])+$/;
		  return regex.test(email);
	}
	
	function changeInfo(username, password, email, name, address, phoneNumber){
		$.ajax({
			type : "POST",
			url : "/E-Invoice_System/updateInfo",
			data : {
				'username' : username,
				'password' : password,
				'email' : email,
				'name' : name,
				'address' : address,
				'phoneNumber' : phoneNumber
			},
			dataType : "json",
			success : function(data) {
				$('#editModal').modal('hide');
				$('#nameStr').empty();
				$('#nameStr').append("<h3 class='panel-title'>"+name+"</h3>");
				$('#emailStr').empty();
				$('#emailStr').append("<td>Email</td><td>"+email+"</td>");
				$('#addressStr').empty();
				$('#addressStr').append("<td>Address</td><td>"+address+"</td>");
				$('#phoneStr').empty();
				$('#phoneStr').append("<td>Phone Number</td><td>"+phoneNumber+"</td>");
				
			}
		});
	}
	
	
	
	function checkData(){
		var email = $("#email").val();
		if (isEmail(email)){
			var password = $('#password').val();
			var password_confirm = $('#password_confirm').val();
			if (password == password_confirm){
				var name = $("#name").val();
				var address = $("#address").val();
				var phoneNumber = $("#telNo").val();
				var username = $("#username").val();
				changeInfo(username, password, email, name, address, phoneNumber);
			}
			
		}
		
	}
	
	

		$("#editsubmit").on('click', function() {
		   checkData();
		});
	

});



