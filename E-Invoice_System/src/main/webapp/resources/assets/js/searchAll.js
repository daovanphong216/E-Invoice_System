$("document").ready(function() {
	
	$('#search-btn').click(function(){
		var searchdata={};
		searchdata.dateMin= $('#startday-input').val();
		searchdata.dateMax= $('#endday-input').val();
		searchdata.typeId= $('#select-option').val();
		searchdata.cCode= $('#customer-code-input').val();
		searchdata.moneyMin= $('#monneystart-input').val();
		searchdata.moneyMax= $('#moneyend-input').val();
		
		if(searchdata.dateMin==''){
			searchdata.dateMin= '1970-1-1';
		}
		if(searchdata.dateMax==''){
			searchdata.dateMin= '3000-12-31';
		}
		
		
		if(searchdata.moneyMin==''){
			searchdata.dateMin= 0;
		}
		
		if(searchdata.moneyMin==''){
			searchdata.dateMin= 1000000000;
		}
		
		if(searchdata.typeId==''){
			searchdata.dateMin= 1;
		}
		
		if(searchdata.cCode==''){
			searchdata.cCode= '';
		}
		
		

		
	});
	
	
});