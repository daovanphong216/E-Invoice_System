$("document").ready(function() {
	
	var totalUsers = 0;
	var activeUsers = 0;
	var deactiveUsers = 0;
	var results = [];
	var totalRecords = 0;
	var totalPages = 0;
	var displayResults = [];
	var recPerPage =10;
	var currentPage = 1;
	first_buton="<li class='page-item disabled'><a class='page-link' href='#' tabindex='-1'>First</a></li>";
	const beginDisableStr="<li class='page-item disabled'><a class='page-link' href='#' tabindex='-1'>";
	const beginActiveStr="<li class='page-item active'><a class='page-link' href='#'>";
	const beginNomalStr="<li class='page-item'><a class='page-link' href='#'>";
	const endStr="</a></li>";
	
	$('#myModal').modal('hide');
	$("#trigger_button").on('click', function() {
		console.log("hihi");
	    $('#myModal').modal('show');
	});
	

	
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
				results = data;
				totalRecords = results.length;
				totalPages = Math.ceil(totalRecords / recPerPage);
				currentPage = 1;
				setData();
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
		});
	}
	
	function generate_table() {
		
		$('#table_body').empty();
		if (displayResults != null) {
			var data_get = '';
			$.each(displayResults	, function(key, value) {
				data_get += '<tr>';
				data_get += '<td>' + (+key+1 + 10*(currentPage-1)) + '</td>';
				data_get += "<td><a href='./userinfo/" +value.id+"'>"+value.userName+"</a></td>";
				if (value.active==true){
					data_get += '<td>' + "Active" + '</td>';
					//data_get += '<td>' + "Deactive" + '</td>';
					data_get += "<td><a href='#' account_id='" + value.id + "' status='active' pos='" + key + "'>Deactive this user</a></td>";
				} else {
					data_get += '<td>' + "Dective" + '</td>';
					data_get += "<td><a href='#' account_id='" + value.id + "' status='deactive' pos='" + key + "'>Active this user</a></td>";
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
				console.log(data);
			}
		});
		
		

	}
	
	function setGeneralInfo(){
		$("#general_info").empty();
		$("#general_info").append("<h5>Total users: " + totalUsers + " &nbsp&nbsp&nbsp|&nbsp&nbsp&nbsp Actived users: " + activeUsers + " &nbsp&nbsp&nbsp|&nbsp&nbsp&nbsp Deactived users: " + deactiveUsers +"</h5>" );
	}
	
	/*$.ajax({
		type : "POST",
		url : "/E-Invoice_System/searchAccount",
		data : {
			'username' : "",
			'type' : "all"
		},
		dataType : "json",
		success : function(data) {
			results = data;
			totalRecords = results.length;
			totalUsers=totalRecords;
			for (var i=0; i<totalRecords; i++){
				if (results[i].active){
					activeUsers++;
				} else {
					deactiveUsers ++;
				}
			}
			console.log("Total users: " + totalUsers + "  |  Actived users: " + activeUsers + "  |  Deactived users: " + deactiveUsers  );
			totalPages = Math.ceil(totalRecords / recPerPage);
			currentPage= (totalPages>0) * 1;
			setData();
		}
	});*/

	
	function handlePagination(pageValue){
		switch (pageValue){
			case "First":
				if (currentPage!=1) {
					currentPage=1;
					setData();
					}
				break;
			case "Previous":
				if (currentPage!=1) {
					currentPage-=1;
					setData();
					}
				break;
			case "Next":
				if (currentPage!=totalPages) {
					currentPage+=1;
					setData();
					}
				break;
			case "Last":
				if (currentPage!=totalPages) {
					currentPage=totalPages;
					setData();
					}
				break;
			default:
				currentPage=+pageValue;
				setData();
				break;
			};
			
	}
	
	function setData(){
		displayResults = [];
		if (currentPage >0){
			var pos = recPerPage*(currentPage-1);
			for (var i=pos; i<pos+recPerPage; i++){
				if (i<totalRecords) {
					displayResults.push(results[i]);
				}
			}
		}
		apply_pagination();
	}
	
	
	function apply_pagination(){
		$('#pager').empty();
		var page="";
		var pageValue=["First","Previous","","","","","","Next","Last"];
		var pageState=[0,0,0,0,0,0,0,0,0];
		var activePage=3;
		
		if (totalPages <= 5){
			for (var i=1; i<=totalPages;i++){
				pageValue[i+1] = i;
			}
			activePage = currentPage+1;
		}else{
			if (currentPage<=3){
				for (var i=1; i<=5;i++){
					pageValue[i+1] = i;
				}
				activePage = currentPage+1;
			} else if (currentPage<totalPages-1){
				for (var i=1; i<=5;i++){
					pageValue[i+1] = currentPage+i-3;
				}
				activePage = 4;
			} else if (currentPage>=totalPages-1){
				for (var i=1; i<=5;i++){
					pageValue[i+1] = totalPages-5+i;
				}
				activePage = 6 - (totalPages-currentPage);
			}
		}
		
		
		

		switch (totalPages){
		case 0:
			pageState[0]=-1;
			pageState[1]=-1;
			pageState[7]=-1;
			pageState[8]=-1;
			break;
		case 1:
			pageState[0]=-1;
			pageState[1]=-1;
			pageState[7]=-1;
			pageState[8]=-1;
			break;			
		default:
			switch(currentPage)
			{
			case 1: 
				pageState[0]=-1;
				pageState[1]=-1;
				break;
			case totalPages:
				pageState[7]=-1;
				pageState[8]=-1;
				break;
			}
			break;
		}
		pageState[activePage] = 1;
		for(var i=0; i<9; i++){
			if (pageValue[i]!=""){
				switch (pageState[i]){
				case -1: 
					page=beginDisableStr + pageValue[i] + endStr;
					break;
				case 0: 
					page=beginNomalStr + pageValue[i] + endStr;
					break;
				case 1: 
					page=beginActiveStr + pageValue[i] + endStr;
					break;
				}
				$('#pager').append(page);
			}
		}
		generate_table();
		$('#pager a').click(function() {
				var txt = $(this).text();
				handlePagination(txt);
			});
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
