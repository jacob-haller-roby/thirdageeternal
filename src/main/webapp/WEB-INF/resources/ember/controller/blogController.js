App.BlogController = Ember.ObjectController.extend({
	actions : {
		developer : function() {
			this.transitionToRoute("feed", App.Blog.developer());
		},
		news : function() {
			this.transitionToRoute("feed", App.Blog.news());
		},
		article : function(post) {
			this.transitionToRoute("article", post);
		},
		write : function() {
			this.transitionToRoute("write");
		}
	}
});

App.WriteController = Ember.ObjectController.extend({
	actions : {
		submit : function() {
			App.Blog.submit({
				output : this.get('output'),
				category : this.get('category'),
				title : this.get('title')
			});
			this.transitionToRoute("blog_submit");
		}
	}
});

App.FeedController = Ember.ObjectController.extend({
	actions : {
		article : function(post) {
			this.transitionToRoute("article", post);
		}
	}
});

App.ArticleController = Ember.ObjectController.extend({
	actions : {
		edit : function() {
			this.set('edit', true);
		},
		save : function() {
			App.Blog.update({
				output : this.get('output'),
				title : this.get('title'),
				id : this.get('id')
			});
			this.set('edit', false);
		},
		cancel : function(){
			var view = this;
			 App.Blog.getArticle(this.get('id')).then(function(result){
				 view.set('model', result);
				 view.set('edit', false);
			 });
		},
		comment : function(){
			var comment = {
					output : this.get('newComment'),
					blogId : this.get('id')
			};
			
			App.Blog.comment(comment);
			this.set('commentSent', true);
		}
	}
});