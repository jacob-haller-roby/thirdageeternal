<%@include file="/WEB-INF/resources/includes/taglib.jspf"%>

<div class="row">
	<span class="blog-title">{{title}}</span><br>
</div>
<div class="row top-buffer">
	<pre>{{output}}</pre>
</div>
<div class="row">
	<span class="text-credit">Author: {{createdBy.login}} on
		{{dateFormat createdAt}}</span>
</div>


<security:authorize access="isAuthenticated()">
	

	{{#if edit}}
	<div class="row">
		<div class="col-sm-12">{{view App.TextField id="newBlogTitle"
			name="title" valueBinding="title" hint="Blog Title"
			class="wide-text"}}</div>
	</div>

	<div class="row top-buffer">
		<div class="col-sm-12 col-centered">{{view App.TextArea
			id="newBlogOutput"name="output" valueBinding="output"
			class="blog-text-area" hint="Blog Content"}}</div>

		<div class="row top-buffer">
			<div class="col-sm-3 col-sm-offset-5">
				<button {{action save}} class="wide-text">Save</button>
			</div>
			<div class="col-sm-3">
				<button {{action cancel}} class="wide-text">Cancel</button>
			</div>
		</div>
	</div>
	{{else}}
	<div class="row top-buffer">
		<div class="col-sm-4 col-sm-offset-7">
			<button {{action edit}}>Edit</button>
		</div>
	</div>
	{{/if}}
</security:authorize>


<div class="row top-buffer">
	<div class="col-sm-3 col-centered">
		Blog Comments:
	</div>
</div>

{{#each comment in blogComments}}
<div class="row top-buffer">
	<div class="col-sm-10 col-centered">
		{{comment.output}}
	</div>
</div>
<div class="row">
	<div class="col-sm-8 col-centered text-centered">
		<span class="text-credit">Author: {{comment.createdBy.login}} on {{dateFormat comment.createdAt}}</span>
	</div>
</div>
{{/each}}

<security:authorize access="isAuthenticated()">
	{{#if commentSent}}
		<div class="row top-buffer">
			<div class="col-sm-10 col-centered">
				{{newComment}}
			</div>
		</div>
	{{else}}
	<div class="row top-buffer">
		<div class="col-sm-10 col-centered">{{view App.TextArea
			id="newComment" name="newComment" valueBinding="newComment"
			class="blog-text-area" hint="Add a Comment"}}</div>

		<div class="row top-buffer">
			<div class="col-sm-4 col-sm-offset-7">
				<button {{action comment}} class="wide-text">Submit</button>
			</div>
		</div>
	</div>
	{{/if}}
</security:authorize>