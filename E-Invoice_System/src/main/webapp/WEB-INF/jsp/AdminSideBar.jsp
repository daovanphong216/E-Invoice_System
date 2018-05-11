<!-- side bar -->
<script src="./resources/assets/js/AdminSideBar.js"></script>
<div class="nav collapse navbar-collapse navbar-ex1-collapse ta-sidebar">
	<ul class="nav navbar-nav side-nav sidebar">

		<h3>Add Admin</h3>
		<div class="body-form">
			<label for="uname"><b>User Name</b></label> <br> <input
				type="text" id="username" placeholder="Enter User Name"
				name="username" pattern=".{0}|.{5,25}" required
				title="Must 5 or more chars (max 25)" maxlength="25"> <label
				for="psw"><b>Password</b></label> <br> <input id="password" name="password"
				placeholder="Enter Password" required="required" type="password"
				id="password" /> <label for="psw-repeat"><b>Confirm
					Password</b></label> <br> <input id="password_confirm" name="password_confirm"
				placeholder="Confirm Password" required="required" type="password"
				id="password_confirm" onblur="checkPassword();" />

			<button id="add_admin" class="registerbtn btn btn-default">Done</button>

		</div>
</br>
<hr>
<h3>Admin list</h3>
		<div class="body-form" id="admin_list">
			
			<div class="panel-group" id="accordion">
				<div class="panel panel-default">
					<div class="panel-heading">
						<h4 class="panel-title">
							<a data-toggle="collapse" data-parent="#accordion"
								href="#collapse1">Collapsible Group 1</a>
						</h4>
					</div>
					<div id="collapse1" class="panel-collapse collapse in">
						<div class="panel-body">Hihi.</div>
					</div>
				</div>
			</div>
			
		</div>
	</ul>





</div>

