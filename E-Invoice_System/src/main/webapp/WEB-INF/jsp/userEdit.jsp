
 <!-- Modal content-->
 <div class=".ueditcontainer">
	<div class="modal-header" style="padding:35px 50px;">
		<button type="button" class="close" data-dismiss="modal">&times;</button>
		<h4><span class="glyphicon glyphicon-level-up"></span> Edit User </h4>
	</div>
		<div class="modal-body" style="padding:40px 50px;">
			<form class="body-form">
						<label for="email"><b>Email</b></label><br>
					    <input type="email" placeholder="Enter Email" id="email" required value="${user.email}">
					
						<label for="uname"><b>User Name</b></label><br>
					    <input type="text" placeholder="Enter User Name" id="username" required value="${username}" readonly>
					
						<label for="name"><b>Full Name</b></label><br>
					    <input type="name" placeholder="Enter Your Name" id="name" pattern=".{0}|.{5,50}" required title="Must 5 or more chars (max 50)" maxlength="50" required value="${user.name}">
					
						<label for="add"><b>Address</b></label><br>
					    <input type="text" placeholder="Enter Address" id="address" required required value="${user.address}">
					
						<label for="telNo"><b>Phone Number</b></label><br>
					    <input type="tel" placeholder="090xxxxxxx" id="telNo" required size="20" minlength="10" maxlength="14" required value="${user.phoneNumber}">
					
					    <label for="psw"><b>Password</b></label><br>
					    <input name="password" placeholder="Enter Password"  type="password" id="password" />
					
					    <label for="psw-repeat"><b>Confirm Password</b></label><br>
					    <input name="password_confirm" placeholder="Confirm Password"  type="password" id="password_confirm" " />
					
						<input type="button" id ="editsubmit" class="btn btn-default" value="Done"></button>
			</form>
	</div>
</div>
<script src="<c:url value='/resources/assets/js/userEdit.js'/>"></script>