<!-- side bar -->
<nav class="nav t-sidebar">
	<ul class="">
		<li class="active"><a href="${pageContext.request.contextPath}/">
				Dashboard
		</a></li>
		<li>		
			<a href="${pageContext.request.contextPath}/yearlychart"> Charts</a>			
		</li>
	</ul>
	<hr>
	
	<form class="search-form-monthly">
	
		<label class="control-label">Invoice Type</label>
		<div class="input-group">
			<select id ="select-option" >
				<option value="volvo">Electric</option>
				<option value="saab">Food</option>
				<option value="audi" selected>Shopping</option>
			</select>
		</div>
		<br>
		
		<label class="control-label">Customer ID</label>
		<div class="input-group">
			<input id="customer-code-input" class="form-control" type="text" placeholder="Enter customer code" />
		</div>
		<br>	
		
		<label class="control-label">Invoice No</label>
		<div class="input-group">
			<input id="invoice-code-input" class="form-control" type="text" placeholder="Enter invoice code" />
		</div>
		<br>	
		
		<label class="control-label">Date</label>
		<div class="input-group">
			<input id = "startday-input" class="form-control" type="date" placeholder="From" onchange="get_start_time()" />
			<input id = "endday-input" class="form-control" type="date" placeholder="To" onchange = "get_end_time()"/>
		</div>
		<br>	
		
		<label class="control-label">Money</label>
		<div class="input-group">
			<input id = "monneystart-input" class="form-control" type="number" placeholder="From"/>
			<input id = "moneyend-input" class="form-control" type="number" placeholder="To"/>
		</div>
		<p id="alert-money"></p>
		<br>
		<button id = "search-btn" type="button" class="btn btn-info" onclick="min_money()">
			<span class="glyphicon glyphicon-search"></span> Search
		</button>
				
		<script type="text/javascript" src="${pageContext.request.contextPath}/resources/assets/js/searchAll.js"></script>	
	</form>
	
	<hr>
	<div class="search-form-monthly">
	<label class="control-label ">Delete Invoice Type</label>
		<div class="input-group">
			<select id ="select-option" >
				<option value="volvo">Electric</option>
				<option value="saab">Food</option>
				<option value="audi" selected>Shopping</option>
			</select>
		</div>
	</div>
</nav>

