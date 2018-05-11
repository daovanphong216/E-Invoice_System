$(document).ready(function(){
	submitEdit();
	$("a.modalstart").on('click', function() {
	    $('#myModal').modal('show');
	});
});

function submitEdit(){
	$(".editsubmit").on('click', function() {
	    $('#myModal').modal('hide');
	});
}

function checkPassword() {
	var input=document.getElementById('password_confirm');
    if (input.value != document.getElementById('password').value) {
        input.setCustomValidity('Password Must be Matching.');
    } else {
        // input is valid -- reset the error message
        input.setCustomValidity('');
    }
}