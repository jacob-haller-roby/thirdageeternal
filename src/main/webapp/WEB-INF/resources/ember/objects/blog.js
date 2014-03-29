App.Blog = Ember.Object.extend();

App.Blog = Ember.Object.reopenClass({
	all : function() {
		return $.getJSON('api/blog/all');
	},
	getArticle : function(id) {
		return $.getJSON('api/blog/article/' + id);
	},
	developer : function() {
		return $.getJSON('api/blog/developer');
	},
	news : function() {
		return $.getJSON('api/blog/news');
	},
	submit : function(json) {
		return $.ajax({
			data : JSON.stringify(json),
			type : "POST",
			url : "api/blog/write",
			contentType : "application/json",
			dataType : "json"
		});
	},
	update : function(json) {
		return $.ajax({
			data : JSON.stringify(json),
			type : "POST",
			url : "api/blog/edit",
			contentType : "application/json",
			dataType : "json"
		});
	},
	comment : function(json) {
		return $.ajax({
			data : JSON.stringify(json),
			type : "POST",
			url : "api/blog/comment",
			contentType : "application/json",
			dataType : "json"
		});
	}
});