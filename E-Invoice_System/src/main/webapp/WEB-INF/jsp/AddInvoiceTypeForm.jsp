<div class="modal-header-invoice" style="padding: 35px 50px;">
	<button type="button" class="close" data-dismiss="modal">&times;</button>
	<h4>
		<span class="glyphicon glyphicon-save-file"></span> Add Invoice Type
	</h4>
</div>
<div class="ucontainer">
	<form class="limitform">
		<label for="typename">Invoice Type</label> 
		<input type="text"
			step="0.1" class="form-control" id="typeaddname"
			placeholder="Enter Type name" name="typeaddname" required> 
		<br>
		<label for="amountOfMoney">Select file</label> 
		<img class="form-group" id='image' name='image' alt='your image' width='150' height='150'>
		
		<input class="form-group" id='file' name='file' , type='file', accept='image/*', 
		onchange="document.getElementById('image').src = window.URL.createObjectURL(this.files[0]);
		document.getElementById('image').style.display = 'block';">
		<br> 
		<input id="add_type" type="button" value="Done" class="btn btn-default" required />
	</form>
	<script type="text/javascript"
		src="././resources/assets/js/AddInvoiceType.js"></script>
</div>