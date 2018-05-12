<div class="modal-header-invoice" style="padding:35px 50px;">
		<button type="button" class="close" data-dismiss="modal">&times;</button>
		<h4><span class="glyphicon glyphicon-save-file"></span> Create Invoice </h4>
</div>
<div class="ucontainer">
	<form class="invoiceform">
		<div class="form-group">
			<label for="customerCode">Customer Code:</label> <input type="number"
				class="form-control" id="customerCode"
				placeholder="Enter Customer Code" name="customerCode">
		</div>
		<div class="form-group">
			<label for="invoiceNo">Invoice Type:</label> 
			<select	title="Select your surfboard" name="type" class="form-control">
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

