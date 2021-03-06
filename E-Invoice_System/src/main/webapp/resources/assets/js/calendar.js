function getInvoicejsonByDate(dateStr) {
    var str;
    $.ajax({
        url: "/E-Invoice_System/getInvoiceFromUser/"+dateStr,
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


function getAllTypesjson(dateStr) {
    var str;
    $.ajax({
        url: "/E-Invoice_System/getAllTypeInforByDate/"+dateStr,
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

function getInvoicejsonById(id) {
    var str;
    $.ajax({
        url: "/E-Invoice_System/getInvoiceById/"+id,
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


function removeinvoice(dateStr) {
    var str;
    $.ajax({
        url: "http://localhost:8080/E-Invoice_System/removeinvoice/"+dateStr,
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



function updateItemToViewList(item, typeid){
	var markup =`
		<div item-div-id='${item.id}' class="l-item">
			<div class="item-col item-ava w3-bar-item w3-circle w3-hide-small">
				<span class='glyphicon glyphicon-level-up'>${item.description[0]}</span><br>
				<span class='glyphicon glyphicon-level-up'>&nbsp;</span>
			</div>
			<div class="item-col item-detail">
				<div class="item-desc">${item.description}</div>
				<div class="item-info"><b>No: </b>${item.invoiceNo} | <b>Money: </b>$${item.amountOfMoney}</div>
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
	
		var divclass = `.list-type${typeid}`
		$(divclass).append(markup);
		$('.removeItem').click(function(){
			
			var index=this.getAttribute("item-id");
			var item = `[item-div-id=${index}]`
			
			var invoice = removeinvoice(index);
			if(invoice!=null){
				$(item).remove();
				console.log('gsf');
				var returnedDay = new Date(invoice.dateTime);
				if((selectedDay.getDate() == returnedDay.getDate()) && (selectedDay.getFullYear() == returnedDay.getFullYear())&& (selectedDay.getMonth() == returnedDay.getMonth())){
					$('.typeno').html('0');
        			$('.typemoney').html('0.00');
					$.get("/E-Invoice_System/gettypereport/"+selectedDay.getFullYear()+"/"+(selectedDay.getMonth()+1)+"/"+selectedDay.getDate(), function(data, status){
		        		for(i in data){
		        			
		        			$('.type'+data[i].id+'no').html(data[i].noOfInvoice);
		        			$('.type'+data[i].id+'money').html(data[i].totalMonney);
		        		}      		
		            });
					
					
					$.get("/E-Invoice_System/getreport/"+selectedDay.getFullYear()+"/"+(selectedDay.getMonth()+1), function(data, status){
						$('.totalDateMoney').html(data[selectedDay.getDate()-1]);
				    });
				}
				if((selectedDay.getFullYear() == returnedDay.getFullYear())&& (selectedDay.getMonth() == returnedDay.getMonth())){

					var year = selectedDay.getFullYear();
					$.get("/E-Invoice_System/getreport/"+year, function(data, status){
						$('.totalMonthMoney').html(data[selectedDay.getMonth()]);
				    });
					}
					
				
			}

		});
		
		$('.updateItem').click(function(){
			indexToUpdate=this.getAttribute("item-id");
			var itemInvoice = getInvoicejsonById(indexToUpdate);
			$('.ucustomerCode').val(itemInvoice.customerCode);
			$('.uinvoiceNo').val(itemInvoice.invoiceNo);
			$('.uVAT').val(itemInvoice.vat);
			$('.uamountOfMoney').val(itemInvoice.amountOfMoney);
			$('.udescription').val(itemInvoice.description);
			dd = new Date(itemInvoice.dateTime);
			console.log(dd);
			$('.udateTime').val(getSelectedDateString(selectedDay));
			
			
			
		});
		
}


$(document).ready(function () {
	
	
	// ----------------------------------------------------------------------
	
	


	function listDataArray(data){
				for(var i in data){
					updateItemToViewList(data[i])
				};
		
		
		
		
		
		
	};	
	
	
	// -------------------------------------------------------------------------
	
	
	
	
	
	
	
	
	
    var currentDate = new Date();
    selectedDay = currentDate;
    
    
    
    
    
    generateType(selectedDay);
   
    
    
    function generateList(sd){ 	
    	var datestr = getSelectedDateString(sd)
    	
    	jsonData = getInvoicejsonByDate(datestr);
    	listDataArray(jsonData);
    	
    };
    
    function generateType(sd){
    	var datestr = getSelectedDateString(sd)
    	var typesJson = getAllTypesjson(datestr);
    	$(".select-option" ).empty();
    	$("#select-option" ).empty();
    	$("#select-option" ).append("<option value='0'>All</option>");
		$("#delete_type" ).empty();
    	for(var type in typesJson){
    		addTypeToAllView(typesJson[type]);
    		
    	}
    }
    
    
    function generateCalendar(d) {
        function monthDays(month, year) {
            var result = [];
            var days = new Date(year, month, 0).getDate();
            for (var i = 1; i <= days; i++) {
                result.push(i);
            }
            return result;
        }
        Date.prototype.monthDays = function () {
            var d = new Date(this.getFullYear(), this.getMonth() + 1, 0);
            return d.getDate();
        };
        var details = {
            // totalDays: monthDays(d.getMonth(), d.getFullYear()),
            totalDays: d.monthDays(),
            weekDays: ['Su', 'Mon', 'Tue', 'Wed', 'Thu', 'Fri', 'Sat'],
            months: ['January', 'February', 'March', 'April', 'May', 'June', 'July', 'August', 'September', 'October', 'November', 'December'],
        };
        var start = new Date(d.getFullYear(), d.getMonth()).getDay();
        var cal = [];
        var day = 1;
        for (var i = 0; i <= 6; i++) {
            cal.push(['<tr>']);
            for (var j = 0; j < 7; j++) {
                if (i === 0) {
                    cal[i].push('<td>' + details.weekDays[j] + '</td>');
                } else if (day > details.totalDays) {
                    cal[i].push('<td>&nbsp;</td>');
                } else {
                    if (i === 1 && j < start) {
                        cal[i].push('<td>&nbsp;</td>');
                    } else {
                    	if(day == selectedDay.getDate() && d.getMonth()== selectedDay.getMonth() && d.getFullYear()== selectedDay.getFullYear()){
                            cal[i].push('<td class="day selectedday"><a class="dlink" href="#" dd="'+ day++ +'" mm="'+ d.getMonth() +'" yy="'+ d.getFullYear() +'">' + (day-1) + '</a></td>');
                    		
                    	}else{
                            cal[i].push('<td class="day"><a class="dlink" href="#" dd="'+ day++ +'" mm="'+ d.getMonth() +'" yy="'+ d.getFullYear() +'">' + (day-1) + '</a></td>');
                    	}
                    }
                }
            }
            cal[i].push('</tr>');
        }
        cal = cal.reduce(function (a, b) {
            return a.concat(b);
        }, []).join('');
        $('table').append(cal);
        $('#month').text(details.months[d.getMonth()]);
        $('#year').text(d.getFullYear());
        $('td.day').mouseover(function () {
            $(this).addClass('hover');
        }).mouseout(function () {
            $(this).removeClass('hover');
        });
        $('.dlink').click(function () {
            selectedDay.setDate(this.getAttribute("dd"));
            selectedDay.setMonth(this.getAttribute("mm"));
            selectedDay.setFullYear(this.getAttribute("yy"));
            $('.selectedView').html("");
            generateType(selectedDay);
           // generateList(selectedDay);
            $( "input[name=dateTime]" ).val(getSelectedDateString(selectedDay));
            //
            $("td").removeClass("selectedday");
            this.closest('td').classList.add("selectedday");
            var year = selectedDay.getFullYear();
        	$.get("/E-Invoice_System/getreport/"+year, function(data, status){
        		$('.totalMonthMoney').html(data[selectedDay.getMonth()]);
            });
        	
        	$.get("/E-Invoice_System/getreport/"+year+"/"+(selectedDay.getMonth()+1), function(data, status){
        		$('.totalDateMoney').html(data[selectedDay.getDate()-1]);
            });
        	
        	
        	$.get("/E-Invoice_System/gettypereport/"+year+"/"+(selectedDay.getMonth()+1)+"/"+selectedDay.getDate(), function(data, status){
        		for(i in data){
        			$('.type'+data[i].id+'no').html(data[i].noOfInvoice);
        			$('.type'+data[i].id+'money').html(data[i].totalMonney);
        		}
        		
            });
        	
        });
        
    }
    $('#left').click(function () {
        $('table').text('');
        if (currentDate.getMonth() === 0) {
            currentDate = new Date(currentDate.getFullYear() - 1, 11);
            generateCalendar(currentDate);
        } else {
            currentDate = new Date(currentDate.getFullYear(), currentDate.getMonth() - 1);
            generateCalendar(currentDate);
        }
    });
    $('#right').click(function () {
        $('table').html('<tr></tr>');
        if (currentDate.getMonth() === 11) {
            currentDate = new Date(currentDate.getFullYear() + 1, 0);
            generateCalendar(currentDate);
        } else {
            currentDate = new Date(currentDate.getFullYear(), currentDate.getMonth() + 1);
            generateCalendar(currentDate);
        }
    });
    generateCalendar(currentDate);
})

function addTypeToAllView(type){
	var markup = `<div class="type-block style${(type.id%3)+1} type${type.id}">
        <div class="">
    		<div class="type-title">
    		<img src="/E-Invoice_System/getTypeInfor/${type.id}">
            <a class="type-name" data-toggle="collapse" href='#collapse${type.id}' aria-expanded="false" aria-controls="collapse${type.id}">
                ${type.name}
            </a>
            <span>(</span><span class='type${type.id}no typeno'>0</span><span> invoices)</span>
            <span class='numberofinvoices'>$</span><span class="type${type.id}money typemoney">0.00</span>
            </div>
        <div>
        <div class="collapse" id="collapse${type.id}">
            <div class="list list-type${type.id}">  
            </div>
        </div>
    </div>`;
    		$(".selectedView").append(markup);
    		for(var i in type.invoices){
    			updateItemToViewList(type.invoices[i],type.id);
    		}

    
    			markup = `<option value="${type.id}">${type.name}</option>`;
    			$(".typeSelect" ).append(markup);    			
    			
    			$("#select-option" ).append(markup);
    			if (type.deleteAble==true){
    				$("#delete_type" ).append(markup);
    				}
}