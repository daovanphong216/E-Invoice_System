$("document").ready(function() {
	document.getElementById('image').style.display = "none	";
	
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
					alert(data[0]);
				}
			});
		}
	});
	
});