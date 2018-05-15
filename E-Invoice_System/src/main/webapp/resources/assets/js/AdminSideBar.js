
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
						
						$("#add-admin_form")[0].reset();
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
		var name=$("#typename").val();
		if($('#file').get(0).files.length > 0 && name!="" && name!=null){
			var file=getBase64Image(document.getElementById("image"));
		$.ajax({
			type : "POST",
			url : "/E-Invoice_System/createtype",
			data : {
				'name' : name,
				'file' : file
			},
			dataType : "json",
			success : function(data) {
				$("#add_type_form")[0].reset();
				showType();
				alert(data[0]);
			}
		});
		}
	});
	
	
	 function showType(){
			 $.ajax({
			        url: "/E-Invoice_System/getAllTypesByAdmin/",
			        type: 'GET',
			        async: false,
			        contentType: "application/json; charset=utf-8",
			        dataType: "json",
			        processData: true,
			        success: function (data) {
			        	$("#delete_select" ).empty();
			        	for(var type in data){
							if (data[type].deleteAble==false){
								var markup = `<option value="${data[type].id}">${data[type].name}</option>`;
								$("#delete_select" ).append(markup);
								}
						}
			        },
			        failure: function (data) {
			            alert("Fail " + data);
			        }
	
			    });
			
		}
	 showType();
	 
	 
	  $('#del_type').click(function () {
	    	var type_id= $("#delete_select").val();
	    	$.ajax({
				type : "POST",
				url : "/E-Invoice_System/deleteTypeByAdmin",
				data : {
					'id' : type_id,
				},
				dataType : "json",
				success : function(data) {
					showType();
				}
			});
	    });
});
