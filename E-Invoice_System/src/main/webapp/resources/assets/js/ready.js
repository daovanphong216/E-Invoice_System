function getUser() {
	var username = $("#input-search").val();
	var type = $("#select-option").val();
	$.ajax({
		type : "POST",
		url : "/E-Invoice_System/searchUser",
		data : {
			'username' : username,
			'type' : type
		},
		dataType : "json",
		success : function(data) {
			showUser(data);
		}
	});
}


function showUser(data) {

	$('#table_body').empty();
	if (data != null) {
		var data_get = '';
		$.each(data, function(key, value) {
			data_get += '<tr class="' + value.name + '">';
			data_get += '<td>' + value.userName + '</td>';
			data_get += '<td>' + value.active + '</td>';
			data_get += '</tr>';
		});
		$('#table_body').append(data_get);
		$(".listTable").show();
	}

}

$("document").ready(function() {

	$(".listTable").hide();
	$("#button-search").click(function() {
		getUser();
	});
	

});
