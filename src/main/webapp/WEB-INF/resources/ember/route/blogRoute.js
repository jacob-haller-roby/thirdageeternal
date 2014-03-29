App.BlogRoute = Ember.Route.extend({
	renderTemplate : function() {
		this.render('blog');
		Ember.run.scheduleOnce('afterRender', jqueryInit);
	}

});

App.ArticleRoute = Ember.Route.extend({
	model : function(params) {
		return App.Blog.getArticle(params.id);
	}
});

App.FeedRoute = Ember.Route.extend({
	model : function(params) {
		if (params.url == "all") {
			return App.Blog.all();
		} else if (params.url == "developer") {
			return App.Blog.developer();
		} else if (params.url == "news") {
			return App.Blog.news();
		}
	},
	afterModel : function(model) {
		console.log(model);
	}
});

App.WriteRoute = Ember.Route.extend({
	model : function() {
		return {
			categoryData : [ {
				name : "Developer",
				value : 1
			}, {
				name : "News",
				value : 2
			} ]
		};
	}
});

App.BlogSubmitRoute = Ember.Route.extend({
	renderTemplate : function() {
		this.render("blog_submit");
	}
});