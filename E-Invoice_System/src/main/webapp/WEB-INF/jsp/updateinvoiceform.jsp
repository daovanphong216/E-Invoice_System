<div class="modal-header-invoice" style="padding:35px 50px;">
		<button type="button" class="close" data-dismiss="modal">&times;</button>
		<h4><span class="glyphicon glyphicon-save-file"></span> Update Invoice </h4>
</div>
<div class="ucontainer">
	<form class="invoiceform">
		<div class="form-group">
			<label for="customerCode">Customer Code:</label> <input type="number"
				class="form-control" id="customerCode"
				placeholder="Enter Customer Code" name="ucustomerCode">
		</div>
		<div class="form-group">
			<label for="invoiceNo">Invoice Type:</label> 
			<select	title="Select your surfboard" name="utype" class="form-control">
			</select>
		</div>
		<div class="form-group">
			<label for="invoiceNo">Invoice No:</label> <input type="text"
				class="form-control" id="invoiceNo" placeholder="Enter Invoice No"
				name="uinvoiceNo">
		</div>
		<div class="form-group">
			<label for="dateTime">Date Time:</label> <input type="date"
				class="form-control" id="dateTime" placeholder="Enter Date Time"
				name="udateTime">
		</div>
		<div class="form-group">
			<label for="amountOfMoney">Amount Of Money:</label> <input
				type="number" step="0.1" class="form-control" id="amountOfMoney"
				placeholder="Enter Amount Of Money" name="uamountOfMoney">
		</div>
		<div class="form-group">
			<label for="VAT">VAT:</label> <input type="number" step="0.1"
				class="form-control" id="VAT" placeholder="Enter VAT" name="uVAT">
		</div>
		<div class="form-group">
			<label for="description">Description:</label> <input type="text"
				class="form-control" id="description" required
				placeholder="Enter Description" name="udescription">
		</div>
		<input type="button" value="Update"
			class="btn btn-default create-button" />
	</form>
</div>

