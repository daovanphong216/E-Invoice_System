<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1"
	charset="UTF-8">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<style>
.modal-header, h4, .close {
	background-color: #5cb85c;
	color: white!importance;
	text-align: center;
	font-size: 30px;
}

.modal-footer {
	background-color: #f9f9f9;
}

body {
	max-width: 800px;
	min-width: 500px;
	min-height: 800px;
}

/* Full-width input fields */
input[type=text], input[type=password], input[type=email], input[type=name],
	input[type=tel] {
	width: 100%;
	padding: 5px;
	margin: 5px 0 22px 0;
	display: inline-block;
	border: none;
	background: white;
	box-shadow: 2px 2px 5px black;
}

input[type=text]:focus, input[type=password]:focus, input[type=email]:focus,
	input[type=name]:focus, input[type=tel]:focus {
	background-color: #f1f1f1;
	outline: none;
}

container {
	margin-left: 160px;
}

.i-circle {
	background: #318b8fb3;
	color: #fff;
	padding: 6px 0px;
	border-radius: 100%;
	font-size: 30px;
	text-align: center;
	width: 57px;
}

.col-lg-9 {
	width: 81%;
}

.rows {
	margin-top: 30px;
	margin-left: 30px;
	width: 500px;
}

.list-group {
	width: 500px;
}

.list-detal {
	margin-top: 50px;
}

.P-List-invoice {
	align: center;
	width: 100%;
}

ul li {
	height: 80px;
	width: 600px;
}

li.borderless {
	border-left: none;
	border-right: none;
}

.center {
	margin-top: auto;
	margin-bottom: auto;
}

span.delete {
	color: #ad1515;
	width: 5px;
	height: 5px;
}

span.edit {
	color: #78a779;
	width: 5px;
	height: 5px;
}

.center {
	margin: auto;
	magin-top: 50px!importance;
}
</style>
</head>

<body>

	<div class="container align-items-center">
		<div class="container ">

			<!-- Trigger the modal with a button -->
			<button type="button" class="btn btn-default btn-lg align-bottom"
				id="myBtn">Create</button>

			<!-- Modal -->
			<div class="modal fade" id="myModal" role="dialog">
				<div class="modal-dialog">

					<!-- Modal content-->
					<div class="modal-content">
						<div class="modal-header" style="padding: 35px 50px;">
							<button type="button" class="close" data-dismiss="modal">&times;</button>
							<h4>
								<span class="glyphicon glyphicon-lock"></span> Create Invoice
							</h4>
						</div>
						<div class="modal-body" style="padding: 40px 50px;">
							<form role="form" id="createinvoiceform">

								<label for="email"><b>Email</b></label><br> <input
									type="email" placeholder="Enter Email" name="email" required><br>

								<label for="uname"><b>User Name</b></label><br> <input
									type="text" placeholder="Enter User Name" name="uname" required><br>

								<label for="name"><b>Full Name</b></label><br> <input
									type="name" placeholder="Enter Your Name" name="name" required>
								<br> <label for="add"><b>Address</b></label><br> <input
									type="text" placeholder="Enter Address" name="add" required><br>

								<label for="telNo"><b>Phone Number</b></label><br> <input
									type="tel" placeholder="090xxxxxxx" name="telNo" required
									size="20" minlength="10" maxlength="14"><br> <label
									for="psw"><b>Password</b></label><br> <input
									type="password" placeholder="Enter Password" name="psw"
									required><br> <label for="psw-repeat"><b>Confirm
										Password</b></label><br> <input type="password"
									placeholder="Confirm Password" name="psw-repeat" required><br>
								<button type="submit" class="btn btn-success btn-block">
									<span class="glyphicon glyphicon-off"></span> Login
								</button>
							</form>
						</div>
					</div>

				</div>
			</div>
		</div>

		<div class="P-List-invoice">
			<ul class="list-group list-detal center">

			</ul>
		</div>
	</div>
	<script>
		var array = ['1','2','3','4','5','6','7','8','9','10'];
		var array2 = ["Phong","TenTen","La","Thang","Loc","Huu","Ma","Thien","Thang","Tam"];
		var array3 = [23,25,26,46,44,11,22,33,44,55];
		var arrayType = ["Dien","Nuoc","Thue","Su dung sin hoat","Xang","Tiet kiem"];

		$(document).ready(function(){
            $('.container .P-List-invoice .list-group').ready(function(){
				for(var i = 0; i < array.length; i++){
					var markup = "<li class='list-group-item d-flex justify-content-between align-items-center borderless'>"+"<span class='i-circle align-self-center col-sm-4 col-lg-4 col-xs-4'>"+
					array[i]+"</span>"
				+"<span class='align-self-center col-xs-9 col-lg-9 P-info-invoice' valign='center'><b style='font-size:20px'>"
				+ array2[i]
				+"</b></br>"
				+ "|" + array3[i] 
				+ "|" + arrayType[i]+
				"</span>"
				+"<span class='align-self-center col-xs-1 col-lg-1' valign='center'>"
				+"<span class='glyphicon glyphicon-remove delete'/>"
				+"</br>"
				+"<span class='glyphicon glyphicon-edit edit'/>"
				+"</span></li>";
         
					$(".container .P-List-invoice .list-group").append(markup);
				}
            });
			
			$("#myBtn").click(function(){
					$("#myModal").modal('show');
			});
		});
</script>

</body>
</html>