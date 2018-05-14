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
		document.getElementById("alert-money").innerHTML = "Your enter value must more than " + x;
	}
}
