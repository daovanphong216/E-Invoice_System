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

$("document").ready(function() {
	document.getElementById('image').style.display = "none	";
	
	

	$('#add_type').click(function(){
		if($('.addtypeform').valid()){
			var name=$("#typeaddname").val();
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
						$(".limitform")[1].reset();
						
						if(data!=null){
							showType(data);
							$('#AddInvoiceTypeModal').modal('hide');
						}
						else{
							alert('This type is duplicated')
						}
					}
				});
			}
		}	
	});
	
	function getAllTypesjson(dateStr) {
		console.log(dateStr);
	    var str;
	    $.ajax({
	        url: "/E-Invoice_System/getAllTypeInforByDate/"+dateStr,
	        type: 'GET',
	        async: false,
	        contentType: "application/json; charset=utf-8",
	        dataType: "json",
	        processData: true,
	        success: function (data) {
	            str = data;
	        },
	        failure: function (data) {
	            alert("Fail " + data);
	        }

	    });
	    return str;
	}
	
	function showType(data){
		addTypeToAllView(data);	
	}
});