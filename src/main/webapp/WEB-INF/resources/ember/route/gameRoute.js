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

App.MapView = Ember.View.extend({
	didInsertElement: function(){
		mapSetup();
	}
});

App.AristocracyRoute = Ember.Route.extend({
	
});