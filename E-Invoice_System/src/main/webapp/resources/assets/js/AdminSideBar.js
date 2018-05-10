$("document").ready(function() {
	var results = [];
	const beginStr = "<div class='panel-group' id='accordion'><div class='panel panel-default'><div class='panel-heading'><h4 class='panel-title'><a data-toggle='collapse' data-parent='#accordion' href='#collapse";
	const midStr="</a></h4></div><div id='collapse";
	const mid2Str="' class='panel-collapse collapse'><div class='panel-body'>";
	const endStr="</div></div></div></div>";
	
	$('#add_admin').click(function() {
		var username = $('#username').val();
		if (username.length>=5){
			var password = $('#password').val();
			var password_confirm = $('#password_confirm').val();
			if (password == password_confirm){
				
				$.ajax({
					type : "POST",
					url : "/E-Invoice_System/createAdmin",
					data : {
						'username' : username,
						'password' : password
					},
					dataType : "json",
					success : function(data) {
	
					}
				});
			}
		}
	});
	
	function getAllAdmin() {
		$.ajax({
			type : "GET",
			url : "/E-Invoice_System/getAllAdmins",
			dataType : "json",
			success : function(data) {
				results = data;
				showAdmin();
			}
		});
	}
	
	function updateActive(id,status,pos){
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
				} else{
					results[pos].active=true;
				}
				showAdmin();
			}
		});
	}
	
	function showAdmin() {
		
		$('#admin_list').empty();
		for (var i=0; i<results.length; i++){
			var actionStr="";
			if (results[i].active==true){
				actionStr="<a href='#' account_id='" + results[i].id + "' status='active' pos='" + i + "'>Deactive this admin</a>";
			} else{
				actionStr="<a href='#' account_id='" + results[i].id + "' status='deactive' pos='" + i + "'>Active this admin</a>";
			}
			$('#admin_list').append(beginStr + i + "'>" + results[i].userName + midStr + i + mid2Str + actionStr + endStr);
			
		}
		
			
			$('#admin_list a').click(function() {
				var id = $(this).attr("account_id");
				var status = $(this).attr("status");
				var pos = $(this).attr("pos");
				updateActive(id,status, pos);
			});
			
		
		

	}

	getAllAdmin();
	
});
