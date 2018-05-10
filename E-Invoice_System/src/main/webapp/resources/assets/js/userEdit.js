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