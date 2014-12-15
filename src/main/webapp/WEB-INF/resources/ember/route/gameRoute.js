App.GameRoute = Ember.Route.extend({
	renderTemplate : function() {
		this.render('game');
	}
});
// NOT INCLUDED: MAGIC!

App.FactionsRoute = Ember.Route.extend({
	renderTemplate : function() {
		this.render('map');
	}
});

App.MapView = Ember.View.extend({
	didInsertElement : function() {
		mapSetup();
	}
});


App.FactionsAristocracyRoute = Ember.Route.extend({
	actions : {
		didTransition : function() {
			scrollToElement("#factiondesc", 900);
			return true; // Bubble the didTransition event
		}
	}
});

App.FactionsBreakerRoute = Ember.Route.extend({
	actions : {
		didTransition : function() {
			scrollToElement("#factiondesc", 900);
			return true; // Bubble the didTransition event
		}
	}
});

App.FactionsDenizenRoute = Ember.Route.extend({
	actions : {
		didTransition : function() {
			scrollToElement("#factiondesc", 900);
			return true; // Bubble the didTransition event
		}
	}
});

App.FactionsMysticRoute = Ember.Route.extend({
	actions : {
		didTransition : function() {
			scrollToElement("#factiondesc", 900);
			return true; // Bubble the didTransition event
		}
	}
});

App.FactionsSummonerRoute = Ember.Route.extend({
	actions : {
		didTransition : function() {
			scrollToElement("#factiondesc", 900);
			return true; // Bubble the didTransition event
		}
	}
});
