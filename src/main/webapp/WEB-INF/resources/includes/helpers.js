Ember.Handlebars.registerHelper("currentDate",
		function() {
			var date = new Date(), day = date.getDate(), month = date
					.getMonth() + 1, year = String(date.getFullYear());
			return (month < 10 ? '0' : '') + month + '/'
					+ (day < 10 ? '0' : '') + day + '/' + year;
		});

Ember.Handlebars.registerBoundHelper("dateFormat", function(context) {
	var date = new Date(context);
	return date.toUTCString();
});

Ember.Handlebars.registerBoundHelper("readMore", function(str) {
	var maxLength = 1000;
	  if (str.length > maxLength-3)
	    return str.substring(0,maxLength) + '......';
	  return str;
	});

App.Paginated = Ember.Mixin.create({

	pages : function() {

		var availablePages = this.get('availablePages'), pages = [], page;

		for (i = 0; i < availablePages; i++) {
			page = i + 1;

		}

		return pages;

	}.property('availablePages'),

	currentPage : function() {

		return parseInt(this.get('selectedPage'), 10) || 1;

	}.property('selectedPage'),

	nextPage : function() {

		var nextPage = this.get('currentPage') + 1;
		var availablePages = this.get('availablePages');

		if (nextPage <= availablePages) {
			return Ember.Object.create({
				id : nextPage
			});
		} else {
			return Ember.Object.create({
				id : this.get('currentPage')
			});
		}

	}.property('currentPage', 'availablePages'),

	showNext : function() {
		return this.get('currentPage') < this.get('availablePages');
	}.property('currentPage', 'availablePages'),

	prevPage : function() {
		var prevPage = this.get('currentPage') - 1;

		if (prevPage > 0) {
			return Ember.Object.create({
				id : prevPage
			});
		} else {
			return Ember.Object.create({
				id : this.get('currentPage')
			});
		}

	}.property('currentPage'),

	showPrev : function() {
		return this.get('currentPage') != 1;
	}.property('currentPage'),

	availablePages : function() {

		return Math.ceil((this.get('arrangedContent.length') / 10) || 1);

	}.property('arrangedContent.length'),

	prev2Show : function() {
		var pageNumber = this.get('currentPage') - 2;
		return (pageNumber <= this.get('availablePages') && pageNumber > 0);
	}.property('availablePages', 'currentPage'),

	prev2Go : function() {
		var target = this.get('currentPage') - 2;

		if (target > 0 && target <= this.get('availablePages')) {
			return Ember.Object.create({
				id : target
			});
		} else {
			return Ember.Object.create({
				id : this.get('currentPage')
			});
		}

	}.property('currentPage', 'availablePages'),

	next2Show : function() {
		var pageNumber = this.get('currentPage') + 2;
		return (pageNumber <= this.get('availablePages') && pageNumber > 0);
	}.property('availablePages', 'currentPage'),

	next2Go : function() {
		var target = this.get('currentPage') + 2;

		if (target > 0 && target <= this.get('availablePages')) {
			return Ember.Object.create({
				id : target
			});
		} else {
			return Ember.Object.create({
				id : this.get('currentPage')
			});
		}

	}.property('currentPage', 'availablePages'),

	firstShow : function() {
		return this.get('currentPage') > 3;
	}.property('currentPage'),

	firstShowElip : function() {
		return this.get('currentPage') > 4;
	}.property('currentPage'),

	firstGo : function() {
		return Ember.Object.create({
			id : 1
		});
	},

	lastShow : function() {
		return this.get('currentPage') < this.get('availablePages') - 2;
	}.property('currentPage', 'availablePages'),

	lastShowElip : function() {
		return this.get('currentPage') < this.get('availablePages') - 3;
	}.property('currentPage', 'availablePages'),

	lastGo : function() {
		return Ember.Object.create({
			id : this.get('availablePages')
		});
	}.property('availablePages'),

	prevNum : function() {
		return this.get('currentPage') - 1;
	}.property('currentPage'),

	prev2Num : function() {
		return this.get('currentPage') - 2;
	}.property('currentPage'),

	nextNum : function() {
		return this.get('currentPage') + 1;
	}.property('currentPage'),

	next2Num : function() {
		return this.get('currentPage') + 2;
	}.property('currentPage'),

	paginateOn : function() {
		return this.get('availablePages') > 1 && this.get('currentPage') != 0;
	}.property('availablePages', 'currentPage'),

	paginatedContent : function() {
		var models = this.get('arrangedContent');

		if (this.get('selectedPage') == 0) {
			return models;
		}

		var selectedPage = this.get('selectedPage') || 1;
		var upperBound = (selectedPage * 10);
		var lowerBound = (selectedPage * 10) - 10;

		return models.slice(lowerBound, upperBound);

	}.property('selectedPage', 'arrangedContent.@each'),

	actions : {
		sortBy : function(field) {
			var sortField = [ field ];
			if (!this.get('sortProperties')) {
				this.set('sortProperties', sortField);
			} else if (this.get('sortProperties')[0] == field) {
				this.toggleProperty('sortAscending');
			} else {
				this.set('sortProperties', sortField);
			}
		},

		goTo : function(page) {
			this.set('selectedPage', page);
		}
	}
});