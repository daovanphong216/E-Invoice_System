
<div class="ucontainer">
	<h2>Invoice Form</h2>
	<form class="invoiceform">
		<div class="form-group">
			<label for="customerCode">Customer Code:</label> <input type="number"
				class="form-control" id="customerCode"
				placeholder="Enter Customer Code" name="customerCode">
		</div>
		<div class="form-group">
			<label for="invoiceNo">Invoice Type:</label> 
			<select	title="Select your surfboard" name="type" class="form-control">
				<option data-thumbnail="././resources/assets/icon/food.png">Food</option>
				<option data-thumbnail="././resources/assets/icon/food.png">Travel</option>
				<option data-thumbnail="././resources/assets/icon/food.png">Electric</option>
			</select>
		</div>
		<div class="form-group">
			<label for="invoiceNo">Invoice No:</label> <input type="text"
				class="form-control" id="invoiceNo" placeholder="Enter Invoice No"
				name="invoiceNo">
		</div>
		<div class="form-group">
			<label for="dateTime">Date Time:</label> <input type="date"
				class="form-control" id="dateTime" placeholder="Enter Date Time"
				name="dateTime">
		</div>
		<div class="form-group">
			<label for="amountOfMoney">Amount Of Money:</label> <input
				type="number" step="0.1" class="form-control" id="amountOfMoney"
				placeholder="Enter Amount Of Money" name="amountOfMoney">
		</div>
		<div class="form-group">
			<label for="VAT">VAT:</label> <input type="number" step="0.1"
				class="form-control" id="VAT" placeholder="Enter VAT" name="VAT">
		</div>
		<div class="form-group">
			<label for="description">Description:</label> <input type="text"
				class="form-control" id="description" required
				placeholder="Enter Description" name="description">
		</div>
		<input type="button" value="Create"
			class="btn btn-default create-button" />
	</form>
</div>

