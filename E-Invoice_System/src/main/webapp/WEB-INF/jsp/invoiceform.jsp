<!DOCTYPE html>
<html lang="en">
<head>
  <title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
   <link rel="stylesheet" href="././resources/assets/css/Invoices.css">
  
</head>
<body>

<div class="ucontainer">
  <h2>Invoice Form</h2>
  <form action="./CreateInvoice">
    <div class="form-group">
      <label for="customerCode">Customer Code:</label>
      <input type="number" class="form-control" id="customerCode" placeholder="Enter Customer Code" name="customerCode">
    </div>
    <div class="form-group">
      <label for="invoiceNo">Invoice No:</label>
      <input type="text" class="form-control" id="invoiceNo" placeholder="Enter Invoice No" name="invoiceNo">
    </div>
    <div class="form-group">
      <label for="dateTime">Date Time:</label>
      <input type="date" class="form-control" id="dateTime" placeholder="Enter Date Time" name="dateTime">
    </div>
    <div class="form-group">
      <label for="amountOfMoney">Amount Of Money:</label>
      <input type="number" step="0.1" class="form-control" id="amountOfMoney" placeholder="Enter Amount Of Money" name="amountOfMoney">
    </div>
    <div class="form-group">
      <label for="VAT">VAT:</label>
      <input type="number" step="0.1" class="form-control" id="VAT" placeholder="Enter VAT" name="VAT">
    </div>
    <div class="form-group">
      <label for="description">Description:</label>
      <input type="text" class="form-control" id="description" placeholder="Enter Description" name="description">
    </div>
    <button type="submit" class="btn btn-default">Submit</button>
  </form>
</div>

</body>
</html>
