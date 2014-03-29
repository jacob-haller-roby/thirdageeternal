App.TextField = Ember.TextField.extend({
	classNameBindings : [ 'hint-gray' ],
	didInsertElement : function() {
		this.focusOut();
	},
	focusOut : function() {
		if (!this.value) {
			this.set('value', this.hint);
			this.set('hint-gray', true);
		}
	},
	focusIn : function() {
		if (this.value == this.hint) {
			this.set('value', "");
			this.set('hint-gray', false);
		}
	}
});

App.TextArea = Ember.TextArea.extend({
	classNameBindings : [ 'hint-gray' ],
	didInsertElement : function() {
		this.focusOut();
	},
	focusOut : function() {
		if (!this.value) {
			this.set('value', this.hint);
			this.set('hint-gray', true);
		}
	},
	focusIn : function() {
		if (this.value == this.hint) {
			this.set('value', "");
			this.set('hint-gray', false);
		}
	}
});