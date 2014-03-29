<%@include file="/WEB-INF/resources/includes/taglib.jspf"%>
<security:authorize access="isAuthenticated()">

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
			<div class="col-sm-6 col-sm-offset-1">
				<label for="newBlogCategory">Select a Blog Category:&nbsp; </label>
				{{view Ember.Select id="newBlogCategory" valueBinding="category"
				content=categoryData optionValuePath="content.value"
				optionLabelPath="content.name"}}
			</div>
			<div class="col-sm-4">
				<button {{action submit}} class="wide-text">Submit</button>
			</div>
		</div>
	</div>
</security:authorize>