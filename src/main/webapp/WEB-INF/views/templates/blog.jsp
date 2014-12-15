<%@include file="/WEB-INF/resources/includes/taglib.jspf"%>
<div class="col-sm-2 sidebar">
	<div class="panel panel-default">
		<div class="panel-heading" data-toggle="collapse"
			data-parents="#accordion" data-target="#collapseOne">
			<h4 class="panel-title">
				Design Articles
			</h4>
		</div>
		<div id="collapseOne"
			class="panel-collapse collapse in btn-group-vertical">
			{{#link-to 'blog.emotion' class="list-group-item"}}Emotion in Design{{/link-to}}
			{{#link-to 'blog.interplay' class="list-group-item"}}Interplay: A Review{{/link-to}}
		</div>
	</div>
	<div class="panel panel-default">
		<div class="panel-heading" data-toggle="collapse"
			data-parents="#accordion" data-target="#collapseTwo">
			<h4 class="panel-title">
				About Us
			</h4>
		</div>
		<div id="collapseTwo"
			class="panel-collapse collapse in btn-group-vertical">
			{{#link-to 'about' class="list-group-item"}}Real Job LLC{{/link-to}}
			{{#link-to 'blog.nathan' class="list-group-item"}}Nathan Bastert{{/link-to}}
			{{#link-to 'blog.matt' class="list-group-item"}}Matt Martin{{/link-to}}
			{{#link-to 'blog.sam' class="list-group-item"}}Sam Wilson{{/link-to}}
		</div>
	</div>
</div>
<div class="col-sm-10"><div class="blog-background">
	{{outlet}}</div></div>
