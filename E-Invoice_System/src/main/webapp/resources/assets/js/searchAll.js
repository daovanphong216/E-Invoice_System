function get_start_time() {
	var x = document.getElementById("startday-input").value;
	document.getElementById("endday-input").min = x;
}

function get_end_time() {
	var x = document.getElementById("endday-input").value;
	document.getElementById("startday-input").max = x;
}

function min_money() {
	var x = document.getElementById("monneystart-input").value;
	var y = document.getElementById("moneyend-input").value;
	if (x > y) {
		document.getElementById("moneyend-input").min = x;
		document.getElementById("alert-money").innerHTML = "Your enter value must greater than " + x;
	}
}


$("document").ready(function() {
	
	$( "#startday-input" ).change(function() {
		get_start_time();
	});
	
	$( "#endday-input" ).change(function() {
		get_end_time();
	});
	
	$( "#moneyend-input" ).click(function() {
		min_money();
	});
	
	$('#search-btn').click(function(){
		var searchdata={};
		searchdata.dateMin= $('#startday-input').val();
		searchdata.dateMax= $('#endday-input').val();
		searchdata.typeId= $('#select-option').val();
		searchdata.cCode= $('#customer-code-input').val();
		searchdata.moneyMin= $('#monneystart-input').val();
		searchdata.moneyMax= $('#moneyend-input').val();
		searchdata.invoiceNo= $('#invoice-code-input').val();
		
		if(searchdata.dateMin==''){
			searchdata.dateMin= '1970-1-1';
		}
		if(searchdata.dateMax==''){
			searchdata.dateMin= '3000-12-31';
		}
		
		
		if(searchdata.moneyMin==''){
			searchdata.moneyMin= 0;
		}
		
		if(searchdata.moneyMax==''){
			searchdata.moneyMax= 1000000000;
		}
		
		if(searchdata.typeId==''){
			searchdata.dateMin= 1;
		}
		
		if(searchdata.cCode==''){
			searchdata.cCode= '-999999';
		}
		if(searchdata.invoiceNo==''){
			searchdata.invoiceNo= 'none';
		}
		
		window.location.href = `/E-Invoice_System/Search?cCode=${searchdata.cCode}&dateMin=${searchdata.dateMin}&dateMax=${searchdata.dateMax}&moneyMin=${searchdata.moneyMin}&moneyMax=${searchdata.moneyMax}&type=${searchdata.typeId}&invoiceNo=${searchdata.invoiceNo}&firstResult=0&maxResults=10`;
		
		//cCode=99999&dateMin=3000-12-31&dateMax=&moneyMin=0&moneyMax=1000000000&type=1&invoiceNo=123&firstResult=0&maxResults=10	
	});
	
});
