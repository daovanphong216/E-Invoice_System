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
	var totalPages =0;
	var dataSearch = [];
	var recPerPage =10;
	var currentPage;
	const beginDisableStr="<li class='page-item disabled'><a class='page-link' href='";
	const midDisableStr="' tabindex='-1'>";
	const beginActiveStr="<li class='page-item active'><a class='page-link' href='";
	const midStr="'>";
	const beginNomalStr="<li class='page-item'><a class='page-link' href='";
	const endStr="</a></li>";
	
	
	
	
	var options = window.location.search;
	
	
	totalPages = $("#totalPages").val();
	dataSearch = searchDara(options);
	currentPage=$("#currentPage").val();
	
	for(var i in dataSearch){
		updateItemToSearchList(dataSearch[i]);
	}
	
	
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

	var paraName=["","","","","","","","",""];
	var paraValue=["","","","","","","","",""];
	var pairs=options.split("&");
	for (var i=0; i<pairs.length; i++){
		var pairs2= pairs[i].split("=");
		paraName[i]=pairs2[0];
		paraValue[i]=pairs2[1];
	}
	$("#select-option").val(paraValue[5]);
	if (paraValue[0]!="-999999"){
		$("#customer-code-input").val(paraValue[0]);
	}
	if (paraValue[6]!="none"){
		$("#invoice-code-input").val(paraValue[6]);
	}
	if (paraValue[1]!="1970-1-1"){
		$("#startday-input").val(paraValue[1]);
	}
	if (paraValue[2]!="3000-12-31"){
		$("#endday-input").val(paraValue[2]);
	}
	if (paraValue[3]!="0"){
		$("#monneystart-input").val(paraValue[3]);
	}
	if (paraValue[4]!="1000000000"){
		$("#moneyend-input").val(paraValue[4]);
	}
	
	
	apply_pagination();
	function apply_pagination() {
        $('#pager').empty();
        var page = "";
        var pageValue = ["First", "Previous", "", "", "", "", "", "Next", "Last"];
        var pageState = [0, 0, 0, 0, 0, 0, 0, 0, 0];
        var pageNext = [0, 0, 0, 0, 0, 0, 0, 0, 0];
        var activePage = 3;

        if (totalPages <= 5) {
            for (var i = 1; i <= totalPages; i++) {
                pageValue[i + 1] = i;
                pageNext[i + 1] = i;
            }
            activePage = +currentPage + 1;
        } else {
            if (currentPage <= 3) {
                for (var i = 1; i <= 5; i++) {
                    pageValue[i + 1] = i;
                    pageNext[i + 1] = i;
                }
                activePage = +currentPage + 1;
            } else if (currentPage < totalPages - 1) {
                for (var i = 1; i <= 5; i++) {
                    pageValue[i + 1] = currentPage + i - 3;
                    pageNext[i + 1] = currentPage + i - 3;
                }
                activePage = 4;
            } else if (currentPage >= totalPages - 1) {
                for (var i = 1; i <= 5; i++) {
                    pageValue[i + 1] = totalPages - 5 + i;
                    pageNext[i + 1] = totalPages - 5 + i;
                }
                activePage = 6 - (totalPages - currentPage);
            }
        }
        
        pageNext[0]=1;
        pageNext[8]=+totalPages;
        if (currentPage != 1) {
            pageNext[1]=currentPage-1;
        }
        
        if (currentPage != totalPages) {
        	pageNext[7] = +currentPage+1;
        }

        switch (totalPages) {
            case "0":
                pageState[0] = -1;
                pageState[1] = -1;
                pageState[7] = -1;
                pageState[8] = -1;
                break;
            case "1":
                pageState[0] = -1;
                pageState[1] = -1;
                pageState[7] = -1;
                pageState[8] = -1;
                break;
            default:
                switch (currentPage) {
                    case "1":
                        pageState[0] = -1;
                        pageState[1] = -1;
                        break;
                    case totalPages:
                        pageState[7] = -1;
                        pageState[8] = -1;
                        break;
                }
                break;
        }
        pageState[activePage] = 1;
        
        var href=window.location.href;
    	var pos1=href.indexOf("firstResult");
    	var pos2=href.indexOf("&maxResults");
        for (var i = 0; i < 9; i++) {
            if (pageValue[i] != "") {
            	
            	var link="";
            	for (var j=0; j<pos1; j++){

            		link+=href[j];
            	}
            	link+="firstResult=";
            	link+=(pageNext[i]*1)-1;
            	for (var j=pos2; j<href.length; j++){

            		link+=href[j];
            	}
            	//link.replace("firstResult=0","firstResult=" + (currentPage*1)-1);
                switch (pageState[i]) {
                    case -1:
                        page = beginDisableStr + link + midDisableStr+ pageValue[i] + endStr;
                        break;
                    case 0:
                        page = beginNomalStr + link + midStr + pageValue[i] + endStr;
                        break;
                    case 1:
                        page = beginActiveStr + link + midStr + pageValue[i] + endStr;
                        break;
                }
                $('#pager').append(page);
            }
        }
        $('#pager a').click(function() {
            var txt = $(this).text();
            handlePagination(txt);
        });
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