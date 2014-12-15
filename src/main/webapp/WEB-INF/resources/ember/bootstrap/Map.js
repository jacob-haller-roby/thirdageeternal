App.Router.map(function() {
	this.resource("index", {path: "/"}, function(){
		this.resource("blog", {path: "/blog"}, function(){
			this.route("emotion");
			this.route("interplay");
			this.route("nathan");
			this.route("matt");
			this.route("sam");
			this.resource("about", {path: "/about"}, function(){
				
			});
			this.resource("feed", {path: "/feed/:url"}, function(){
				
			});
			this.resource("article", {path: "/article/:id"}, function(){
				this.route("edit");
				this.route("save");
				this.route("comment");
			});
			this.resource("write", function(){
				
			});
			this.resource("blog_submit");
		});
		this.resource("game", {path: "/game"}, function(){
			this.resource("cardlist", function(){
				
			});
			this.resource("search", function(){
				
			});
			this.resource("background", function(){
				
			});
			this.resource("factions", function(){
				this.route("aristocracy");
				this.route("breaker");
				this.route("denizen");
				this.route("mystic");
				this.route("summoner");
			});
			this.resource("howtoplay", {path: "/howtoplay"}, function(){
				this.route("cardtypes");
				this.route("gameplay");
				
			});
			this.resource("basicrules", function(){
				
			});
			this.resource("comprehensiverules", function(){
				
			});
			
		});
		this.resource("settings");
	});
});