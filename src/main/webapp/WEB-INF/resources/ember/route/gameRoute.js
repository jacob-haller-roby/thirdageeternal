App.GameRoute = Ember.Route.extend({
  renderTemplate: function(){
	  this.render('game');
  }
});
//NOT INCLUDED:  MAGIC!

App.FactionsRoute = Ember.Route.extend({
	renderTemplate: function(){
		this.render('map');
	}
});