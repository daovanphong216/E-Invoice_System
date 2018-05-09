function getUser() {
	var username = $("#input-search").val();
	var type = $("#select-option").val();
	$.ajax({
		type : "POST",
		url : "/E-Invoice_System/searchAccount",
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

function setDateTimePicker() {
	var dateTimeValue = $("#datetimepicker").val();
	var x = {
			'datetimepicker' : dateTimeValue,
	};	
	console.log(x);
	$.ajax({
		type : "POST",
		url : "/E-Invoice_System/setDateTimePicker",
		data : {
			'datetimepicker' : dateTimeValue,
		},
		dataType : "json",
		success : function(data) {
			console.log(data);
		}
	});
	
	

}

$("document").ready(function() {

	$("#datetimepicker").val("hihi");
	$(".listTable").hide();
	$("#button-search").click(function() {
		getUser();
	});

	$('.form_datetime').datetimepicker({
		// language: 'fr',
		weekStart : 1,
		todayBtn : 1,
		autoclose : 1,
		todayHighlight : 1,
		startView : 2,
		forceParse : 0,
		showMeridian : 1
	});

	$("#ok-buton").click(function() {
		setDateTimePicker();
	});
	
	var $pagination = $('#pagination'),
	totalRecords = 0,
	records = [],
	displayRecords = [],
	recPerPage = 10,
	page = 1,
	totalPages = 0;
       
	$.ajax({
		url: "http://dummy.restapiexample.com/api/v1/employees",
		async: true,
		dataType: 'json',
		success: function (data) {
			records = data;
			console.log(records);
			totalRecords = records.length;
			totalPages = Math.ceil(totalRecords / recPerPage);
			apply_pagination();
		}
	});
	function generate_table() {
		var tr;
		$('#emp_body').html('');
		for (var i = 0; i < displayRecords.length; i++) {
			tr = $('<tr/>');
			tr.append("<td>" + displayRecords[i].employee_name + "</td>");
			tr.append("<td>" + displayRecords[i].employee_salary + "</td>");
			tr.append("<td>" + displayRecords[i].employee_age + "</td>");
			$('#emp_body').append(tr);
		}
	}
	function apply_pagination() {
		$pagination.twbsPagination({
			totalPages: totalPages,
			visiblePages: 6,
			onPageClick: function (event, page) {
				displayRecordsIndex = Math.max(page - 1, 0) * recPerPage;
				endRec = (displayRecordsIndex) + recPerPage;
				console.log(displayRecordsIndex + 'ssssssssss'+ endRec);
				displayRecords = records.slice(displayRecordsIndex, endRec);
				generate_table();
			}
		});
	}

});
