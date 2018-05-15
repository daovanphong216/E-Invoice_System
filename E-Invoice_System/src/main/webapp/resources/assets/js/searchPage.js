function searchDara(options){
	var str;
    $.ajax({
        url: "/E-Invoice_System/SearchInvoice"+options,
        type: 'GET',
        async: false,
        contentType: "application/json; charset=utf-8",
        dataType: "json",
        processData: true,
        success: function (data) {
            str = data;
        },
        failure: function (data) {
            alert("Fail " + data);
        }

    });
    return str;
}

$("document").ready(function() {
	var options = window.location.search;
	dataSearch = searchDara(options);
	for(var i in dataSearch){
		updateItemToSearchList(dataSearch[i]);
	}
});


function updateItemToSearchList(item){
	var markup =`
		<div item-div-id='${item.id}' class="l-item">
			<div class="item-col item-ava w3-bar-item w3-circle w3-hide-small">
				<span class='glyphicon glyphicon-level-up'>${item.description[0]}</span><br>
				<span class='glyphicon glyphicon-level-up'>&nbsp;</span>
			</div>
			<div class="item-col item-detail">
				<div class="item-desc">${item.description}</div>
				<div class="item-info">
					<b>No: </b>${item.invoiceNo} | 
					<b>Money: </b>$${item.amountOfMoney} |
					<b>Date: </b>${item.dateTime}
				</div>
			</div>
			<div class="item-col item-buttons">
				<button item-id='${item.id}' class='btn btn-default btn-sm item-button removeItem'>
					<span class='glyphicon glyphicon-remove-sign'></span>
				</button>
            	<button item-id='${item.id}' data-toggle="modal"
			data-target="#UpdateInvoiceFormModal" type='button' class='btn btn-default btn-sm updateItem'>
                	<span class='glyphicon glyphicon-level-up'></span>
            	</button>    
			</div>
		</div>			
		`;
	// ------------------------------------------------------
	// ----------------------Here-------------------
	
		var divclass = `.search-result`
		$(divclass).append(markup);
}