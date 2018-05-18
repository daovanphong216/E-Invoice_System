<!-- side bar -->
<nav class="nav t-sidebar">
	<ul class="">
		<li class="active"><a href="${pageContext.request.contextPath}/">
				Dashboard
		</a></li>
		<li>		
			<a href="${pageContext.request.contextPath}/charts"> Charts</a>			
		</li>
	</ul>
	<hr>
	
	<form class="search-form-monthly search-form">
	
		<label class="control-label">Invoice Type</label>
		<div class="input-group ">
			<select id ="select-option" class="form-control">
				<option value="0">All</option>
			</select>
		</div>
		<br>
		
		<label class="control-label">Customer Code</label>
		<div class="input-group">
			<input id="customer-code-input" class="form-control" type="text" placeholder="Enter customer code" 
			name="customerCode" min="100000" max="999999999" title="Must 6 or more chars (max 9)"/>
		</div>
		<br>	
		
		<label class="control-label">Invoice No</label>
		<div class="input-group">
			<input id="invoice-code-input" class="form-control" type="text" placeholder="Enter invoice code" 
			name="invoiceNo" pattern=".{0}|.{4,20}" title="Must 4 or more chars (max 20)" maxlength="20"/>
		</div>
		<br>	
		
		<label class="control-label">Date</label>
		<div class="input-group">
			<input id = "startday-input" class="form-control" type="date"/>
			<input id = "endday-input" class="form-control" type="date"/>
		</div>
		<br>	
		
		<label class="control-label">Money</label>
		<div class="input-group">
			<input id = "monneystart-input" class="form-control" type="number" placeholder="From" min="0"/>
			<input id = "moneyend-input" class="form-control" type="number" placeholder="To"/>
		</div>
		<p id="alert-money"></p>
		<br>
		<button id = "search-btn" type="button" class="btn btn-info">
			<span class="glyphicon glyphicon-search"></span> Search
		</button>
				
		
	</form>
	
	<hr>
	<div class="search-form-monthly">
	<label class="control-label ">Delete Invoice Type</label>
		<div class="input-group">
			<select id ="delete_type" class="form-control">
			</select>
		</div>
		<button id = "delete_type_btn" type="button" class="btn btn-info">
			<span class="glyphicon "></span> Delete
		</button>
	</div>
</nav>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/assets/js/searchAll.js"></script>	
