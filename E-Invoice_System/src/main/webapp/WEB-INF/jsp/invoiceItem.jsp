<div class="media">
	<div class="media-left">
		<div class="media-icon">{{i.description[0]}}</div>
	</div>
	<button ng-click="removeElem(i)">x</button>
	<div class="media-body">
		<h4 class="media-heading">{{i.description}}</h4>
		<p>{{i.id}}| {{i.dateTime}} | {{i.invoiceNo}} | {{i.vat}} |
			{{i.amountOfMoney}}</p>
	</div>
</div>