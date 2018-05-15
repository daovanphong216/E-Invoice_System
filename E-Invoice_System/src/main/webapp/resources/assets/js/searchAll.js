$("document").ready(function() {
	
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
			searchdata.dateMax= '3000-12-31';
		}
		
		
		if(searchdata.moneyMin==''){
			searchdata.moneyMin= 0;
		}
		
		if(searchdata.moneyMax==''){
			searchdata.moneyMax= 1000000000;
		}
		
		if(searchdata.typeId==null){
			searchdata.typeId= 1;
		}
		
		if(searchdata.typeId==''){
			searchdata.typeId= 1;
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