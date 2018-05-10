
 <!-- Modal content-->
 <div class=".ueditcontainer">
	<div class="modal-header" style="padding:35px 50px;">
		<button type="button" class="close" data-dismiss="modal">&times;</button>
		<h4><span class="glyphicon glyphicon-level-up"></span> Edit User </h4>
	</div>
		<div class="modal-body" style="padding:40px 50px;">
			<form name='f' action="./register" method='POST'>
						<label for="email"><b>Email</b></label><br>
					    <input type="email" placeholder="Enter Email" name="email" required>
					
						<label for="uname"><b>User Name</b></label><br>
					    <input type="text" placeholder="Enter User Name" name="username" pattern=".{0}|.{5,25}" required title="Must 5 or more chars (max 25)" maxlength="25">
					
						<label for="name"><b>Full Name</b></label><br>
					    <input type="name" placeholder="Enter Your Name" name="name" pattern=".{0}|.{5,50}" required title="Must 5 or more chars (max 50)" maxlength="50">
					
						<label for="add"><b>Address</b></label><br>
					    <input type="text" placeholder="Enter Address" name="address" required>
					
						<label for="telNo"><b>Phone Number</b></label><br>
					    <input type="tel" placeholder="090xxxxxxx" name="telNo" required size="20" minlength="10" maxlength="14">
					
					    <label for="psw"><b>Password</b></label><br>
					    <input name="password" placeholder="Enter Password" required="required" type="password" id="password" />
					
					    <label for="psw-repeat"><b>Confirm Password</b></label><br>
					    <input name="password_confirm" placeholder="Confirm Password" required="required" type="password" id="password_confirm" onblur="checkPassword();" />
					
						<input type="button" class="editsubmit btn btn-default" value="Submit"></button>
			</form>
	</div>
</div>