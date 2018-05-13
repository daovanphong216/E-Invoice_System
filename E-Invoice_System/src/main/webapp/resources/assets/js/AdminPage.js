$("document").ready(function() {
	$('#table_body a').click(function() {
		var id = $(this).attr("account_id");
		var status = $(this).attr("status");
		var pos = $(this).attr("pos");
		changeActive(id,status, pos);
	});
	var totalUsers = 0;
	var activeUsers = 0;
	var deactiveUsers = 0;
	var results = [];

	
	$('#timeModal').modal('hide');
	$("#trigger_button").on('click', function() {
	    $('#timeModal').modal('show');
	});
	

	
	function getUser() {
		var username = $("#username-search").val();
		var type = $("#status-option").val();
		var role = $("#role-option").val();
		var page = $("#page").val();
		
		$.ajax({
			type : "POST",
			url : "/E-Invoice_System/searchAccount",
			data : {
				'username' : username,
				'type' : type,
				'role' : role,
				'page' : page
			},
			dataType : "json",
			success : function(data) {
				results = data;
				totalUsers=results.length;
				for (var i=0; i<totalUsers; i++){
					if (results[i].active){
						activeUsers++;
					} else {
						deactiveUsers ++;
					}
				}
				generate_table();
			}
		});
	}
	
	function changeActive(id,status,pos){
		
		$.ajax({
			type : "POST",
			url : "/E-Invoice_System/updateActive",
			data : {
				'id' : id,
				'status' : status
			},   
			dataType : "json",
			success : function(data) {
				if (results.length==0){
					getUser();
				} else{				
					if (status=='active'){
						results[pos].active=false;
						activeUsers--;
						deactiveUsers++;
					} else{
						results[pos].active=true;
						activeUsers++;
						deactiveUsers--;
					}
					generate_table();
				}
			}
		});
	}
	
	function generate_table() {
		
		$('#table_body').empty();
		if (results != null) {
			var data_get = '';
			var currentPage = $("#page").val();
			$.each(results	, function(key, value) {
				data_get += '<tr>';
				data_get += '<td>' + (+key+1 + 10*(currentPage-1)) + '</td>';
				data_get += "<td><a href='./userinfo/" +value.id+"'>"+value.userName+"</a></td>";
				if (value.active==true){
					data_get += '<td>' + "Active" + '</td>';
					//data_get += '<td>' + "Deactive" + '</td>';
					if (value.userName!="admin") {
						data_get += "<td><a href='#' account_id='" + value.id + "' status='active' pos='" + key + "'>Deactive this account</a></td>";
					} else{
						data_get += "<td>Default admin</td>";
					}
				} else {
					data_get += '<td>' + "Dective" + '</td>';
					if (value.userName!="admin") {
						data_get += "<td><a href='#' account_id='" + value.id + "' status='deactive' pos='" + key + "'>Active this account</a></td>";
					} else {
						data_get += "<td>Default admin</td>";
					}
				}
				data_get += '</tr>';
			});
			$('#table_body').append(data_get);
			$(".listTable").show();
			setGeneralInfo();
			$('#table_body a').click(function() {
				var id = $(this).attr("account_id");
				var status = $(this).attr("status");
				var pos = $(this).attr("pos");
				changeActive(id,status, pos);
			});
		}
		

	}

	function setDateTimePicker() {
		var dateTimeValue = $("#datetimepicker").val();

		$.ajax({
			type : "POST",
			url : "/E-Invoice_System/setDateTimePicker",
			data : {
				'datetimepicker' : dateTimeValue,
			},
			dataType : "json",
			success : function(data) {
			}
		});
		
		

	}
	
	function setGeneralInfo(){
		$("#general_info").empty();
		$("#general_info").append("Total results: " + totalUsers + " | Active: " + activeUsers + " | Deactive: " + deactiveUsers);
	}
	
	
	
	
	
	
	// $("#datetimepicker").val("hihi");
	
	/*$("#button-search").click(function() {
		getUser();
	});*/

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
	
	
	
	

});
