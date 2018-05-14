
$("document").ready(function() {
	document.getElementById('image').style.display = "none	";
	
	$('#add_admin').click(function() {
		var username = $('#username').val();
		if (username.length>=5){
			var password = $('#password').val();
			var password_confirm = $('#password_confirm').val();
			if (password == password_confirm){
				
				$.ajax({
					type : "POST",
					url : "/E-Invoice_System/createAdmin",
					data : {
						'username' : username,
						'password' : password
					},
					dataType : "json",
					success : function(data) {
						alert(data[0]);
						//getAllAdmin();
					}
				});
			}
		}
	});
		
	function getBase64Image(img) {
        var canvas, ctx, dataURL, base64;
        canvas = document.createElement("canvas");
        ctx = canvas.getContext("2d");
        canvas.width = img.width;
        canvas.height = img.height;
        ctx.drawImage(img, 0, 0);
        dataURL = canvas.toDataURL("image/png");
        base64 = dataURL.replace(/^data:image\/png;base64,/, "");
        return base64;
    }

	$('#add_type').click(function(){
		var file=getBase64Image(document.getElementById("image"));
		var name=$("#typename").val();
		if(file !="" && file!=null && name!="" && name!=null){
		$.ajax({
			type : "POST",
			url : "/E-Invoice_System/createtype",
			data : {
				'name' : name,
				'file' : file
			},
			dataType : "json",
			success : function(data) {
				alert(data[0]);
			}
		});
		}
	});
	
});
