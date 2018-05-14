
<div class=".ueditcontainer">
	<div class="modal-header"">
		<button type="button" class="close" data-dismiss="modal">&times;</button>
		<h4>
			<span class="glyphicon glyphicon-level-up"></span> Setting date time
			alert
		</h4>
	</div>
	<div class="modal-body " style="padding: 40px 50px;">
		<form> 
			<label>Date:</label> 
			<select id="day" name="day"
			class="modal-input">
			<option value="01">1</option>
			<option value="02">2</option>
			<option value="03">3</option>
			<option value="04">4</option>
			<option value="05">5</option>
			<option value="06">6</option>
			<option value="07">7</option>
			<option value="08">8</option>
			<option value="09">9</option>
			<option value="10">10</option>
			<option value="11">11</option>
			<option value="12">12</option>
			<option value="13">13</option>
			<option value="14">14</option>
			<option value="15">15</option>
			<option value="16">16</option>
			<option value="17">17</option>
			<option value="18">18</option>
			<option value="19">19</option>
			<option value="20">20</option>
			<option value="21">21</option>
			<option value="22">22</option>
			<option value="23">23</option>
			<option value="24">24</option>
			<option value="25">25</option>
			<option value="26">26</option>
			<option value="27">27</option>
			<option value="28">28</option>
		</select> <br>
		<label>Time:</label> 
		<input type="time" class="modal-input" id="time" type="time" value="${hour}:${minute}"> <br>
		<button type="button" id = "time_submit" class="btn btn-info">OK</button>
		</form>
	</div>

</div>
<script src="<c:url value='/resources/assets/js/trigger_time_picker.js'/>"></script>