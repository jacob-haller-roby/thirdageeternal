<%@include file="/WEB-INF/resources/includes/taglib.jspf"%>

	
		<div class="col-sm-2">
			<!-- <div class="panel panel-default">
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
			</div> -->
			<div class="panel panel-default">
				<div class="panel-heading" data-toggle="collapse"
					data-parents="#accordion" data-target="#collapseTwo">
					<h4 class="panel-title">
						The World of Third Age
					</h4>
				</div>
				<div id="collapseTwo"
					class="panel-collapse collapse in btn-group-vertical">
					<!-- {{#link-to 'background'
					class="list-group-item"}}Background{{/link-to}} --> {{#link-to
					'factions' class="list-group-item"}}Regions{{/link-to}}</div>
			</div>
			<div class="panel panel-default">
				<div class="panel-heading" data-toggle="collapse"
					data-parents="#accordion" data-target="#collapseThree">
					<h4 class="panel-title">
						How To Play Videos
					</h4>
				</div>
				<div id="collapseThree"
					class="panel-collapse collapse in btn-group-vertical">
					{{#link-to 'howtoplay.cardtypes'
					class="list-group-item"}}Card Types{{/link-to}} 
					{{#link-to 'howtoplay.gameplay'
					class="list-group-item"}}Gameplay{{/link-to}}
					<a class="ember-view list-group-item" href="resources/images/ThirdAgeRulesRevised.pdf">Comprehensive Rulebook</a>
					
</div>
			</div>



		</div>
		<div class="col-sm-10">{{outlet}}</div>

