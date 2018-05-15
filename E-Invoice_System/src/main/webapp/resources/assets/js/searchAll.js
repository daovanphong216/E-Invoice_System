
$("document").ready(function() {
	
	$( "#startday-input" ).change(function() {
		$( "#endday-input" )[0].min = $( "#startday-input" ).val();
	});
	
	$( "#endday-input" ).change(function() {
		$( "#startday-input" )[0].max =  $( "#endday-input" ).val();
	});
	
	$( "#moneyend-input" ).change(function() {
		$( "#monneystart-input" )[0].max = $( "#moneyend-input" ).val();
	});
	
	$( "#monneystart-input" ).change(function() {
		$( "#moneyend-input" )[0].min = $( "#monneystart-input" ).val();
	});
	
	$('#search-btn').click(function(){
		if ($('.search-form-monthly').valid()){
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
			
		}
		
		//cCode=99999&dateMin=3000-12-31&dateMax=&moneyMin=0&moneyMax=1000000000&type=1&invoiceNo=123&firstResult=0&maxResults=1	
	});
	
	function showType(){
		 $.ajax({
		        url: "/E-Invoice_System/getAllTypesByUser",
		        type: 'GET',
		        async: false,
		        contentType: "application/json; charset=utf-8",
		        dataType: "json",
		        processData: true,
		        success: function (data) {
		        	$("#select-option" ).empty();
		        	$("#select-option" ).append("<option value='0'>All</option>");
		    		$("#delete_type" ).empty();
		    		for(var type in data){
		    			var markup = `<option value="${data[type].id}">${data[type].name}</option>`;
		    			$("#select-option" ).append(markup);
		    			if (data[type].deleteAble==true){
		    				markup = `<option value="${data[type].id}">${data[type].name}</option>`;
		    				$("#delete_type" ).append(markup);
		    				}
		    		}
		        },
		        failure: function (data) {
		            alert("Fail " + data);
		        }

		    });
		
	}

	
});
