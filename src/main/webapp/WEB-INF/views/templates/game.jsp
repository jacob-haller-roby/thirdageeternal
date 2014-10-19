<%@include file="/WEB-INF/resources/includes/taglib.jspf"%>

	<div class="row">
		<div class="col-sm-2">
			<div class="panel panel-default">
				<div class="panel-heading" data-toggle="collapse"
					data-parents="#accordion" data-target="#collapseOne">
					<h4 class="panel-title">
						<span class="glyphicon glyphicon-chevron-down">Cards</span>
					</h4>
				</div>
				<div id="collapseOne"
					class="panel-collapse collapse in btn-group-vertical">
					{{#link-to 'cardlist' class="list-group-item"}}Cards{{/link-to}}
					{{#link-to 'search' class="list-group-item"}}Search{{/link-to}}</div>
			</div>
			<div class="panel panel-default">
				<div class="panel-heading" data-toggle="collapse"
					data-parents="#accordion" data-target="#collapseTwo">
					<h4 class="panel-title">
						<span class="glyphicon glyphicon-chevron-down">Lore</span>
					</h4>
				</div>
				<div id="collapseTwo"
					class="panel-collapse collapse in btn-group-vertical">
					{{#link-to 'background'
					class="list-group-item"}}Background{{/link-to}} {{#link-to
					'factions' class="list-group-item"}}Factions{{/link-to}}</div>
			</div>
			<div class="panel panel-default">
				<div class="panel-heading" data-toggle="collapse"
					data-parents="#accordion" data-target="#collapseThree">
					<h4 class="panel-title">
						<span class="glyphicon glyphicon-chevron-down">Rules</span>
					</h4>
				</div>
				<div id="collapseThree"
					class="panel-collapse collapse in btn-group-vertical">
					{{#link-to 'howtoplay'
					class="list-group-item"}}How To Play{{/link-to}} {{#link-to
					'basicrules' class="list-group-item"}}Basic Rulebook{{/link-to}}
					{{#link-to
					'comprehensiverules' class="list-group-item"}}Comprehensive Rulebook{{/link-to}}</div>
			</div>



		</div>
		<div class="col-sm-10">{{outlet}}</div>
	</div>
