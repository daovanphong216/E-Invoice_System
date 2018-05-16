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
					showType();
				}
			});
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
	
	function showType(){
    	var typesJson = getAllTypesjson(new Date());
    	$(".select-option" ).empty();
    	$("#select-option" ).empty();
    	$("#select-option" ).append("<option value='0'>All</option>");
		$("#delete_type" ).empty();
		     
		 for(var type in typesJson){
		    			var markup = `<option value="${typesJson[type].id}">${typesJson[type].name}</option>`;
		    			$(".select-option" ).append(markup);
		    			$("#select-option" ).append(markup);
		    			if (typesJson[type].deleteAble==true){
		    				$("#delete_type" ).append(markup);
		    				}
		    		}		
	}
});