
{{#each post in items}}

<div class="row top-buffer">
	<div class="col-sm-8 col-centered text-centered">
		<span class="blog-title" {{action article post}}>{{post.title}}</span>
	</div>
</div>
<div class="row">
	<div class="col-sm-8 col-centered text-centered">
		<pre>{{readMore post.output}}</pre> <a {{action article post}}>Read More</a>
	</div>
</div>
<div class="row">
	<div class="col-sm-8 col-centered text-centered">
		<span class="text-credit">Author: {{post.createdBy.login}} on {{dateFormat post.createdAt}}</span>
	</div>
</div>

{{/each}}