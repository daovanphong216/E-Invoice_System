<!-- side bar -->
<script src="${pageContext.request.contextPath}/resources/assets/js/AdminSideBar.js"></script>
<div class="nav collapse navbar-collapse navbar-ex1-collapse ta-sidebar">
	
		<div class="body-form" id="admin_list">

			<div class="panel-group" id="accordion">
				<div class="panel panel-default">
					<div class="panel-heading">
						<h3 class="sidebar_link">
							<a data-toggle="collapse" data-parent="#accordion"
								href="#collapse1">Add admin</a>
						</h3>
					</div>
					<div id="collapse1" class="panel-collapse collapse">
						<div class="panel-body">
								<label for="uname"><b>User Name</b></label> <br> <input
									class="add_admin_input" type="text" id="username"
									placeholder="Enter User Name" name="username" required="required">
								<label for="psw"><b>Password</b></label> <br> <input
									class="add_admin_input" id="password" name="password"
									placeholder="Enter Password" required="required" type="password"
									id="password" /> <label for="psw-repeat"><b>Confirm
										Password</b></label> <br> <input class="add_admin_input"
									id="password_confirm" name="password_confirm"
									placeholder="Confirm Password" required="required" type="password"
									id="password_confirm"  />
					
								<button id="add_admin" class="registerbtn btn btn-default">Done</button>
						</div>
					</div>
				</div>
			</div>
		<hr>
		
			
			<div class="panel-group" id="accordion2">
				<div class="panel panel-default">
					<div class="panel-heading">
						<h3 class="sidebar_link">
							<a data-toggle="collapse" data-parent="#accordion"
								href="#collapse2">Add invoice type</a>
						</h3>
					</div>
					<div id="collapse2" class="panel-collapse collapse">
						<div class="panel-body ">
							<label for="typename"><b>Invoice type</b></label> 
							<br> 
							<input class="add_admin_input form-group" type="text" id="typename"
							placeholder="Enter invoice type" name="typename" required="required">
							<img class="form-group"  id = 'image' name='image' alt='your image' width='150' height='150'>
							<input  class="form-group" id='file' name='file' , type='file' , accept='image/*' , 
							onchange="document.getElementById('image').src = window.URL.createObjectURL(this.files[0]);
									document.getElementById('image').style.display = 'block';">
							 <button id="add_type" class="registerbtn btn btn-default">Done</button>
						</div>
					</div>
				</div>
			</div>

		</div>
	





</div>

