
$(document).ready(function() {
	$('.file').change(function(){
		src = window.URL.createObjectURL(this.files[0]);
		console.log(src);
		var request = new XMLHttpRequest(); 
		request.onload = function() {
	       var file = new FileReader();
	       file.onloadend = function() {
	          inputimg = file.result;
	          console.log(typeof(inputimg));
	       }
	       file.readAsDataURL(request.response);
	    };   
	    request.open('GET', src);   
	    request.responseType = 'blob';              
	    request.send(); 
	});
	$('.submit').click(function(){
		$.post("/E-Invoice_System/createtype", {
			name: $('#name').val(),
			file: inputimg.replace('data:image/jpeg;base64,','').replace('data:image/png;base64,','')
		});
	});
});