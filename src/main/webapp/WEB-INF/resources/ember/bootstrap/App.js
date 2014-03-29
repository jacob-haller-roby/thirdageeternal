App = Ember.Application.create();

//
//App.CacheManager = {};
//
//App.CacheManager.put = function(key, value) {
//	var item = JSON.stringify(value);
//	localStorage.setItem(key, item);
//};
//
//App.CacheManager.get = function(key) {
//	var retVal = localStorage.getItem(key);
//	return retVal ? JSON.parse(retVal) : {};
//};
//
//// Security Manager
//App.SecurityManager = {};
//App.SecurityManager.principal = {};
//App.SecurityManager.authorities = {};
//App.SecurityManager.hasRole = function(roleId) {
//	if (this.principal) {
//		return _.find(this.principal.roles, function(userRole) {
//			return (userRole === roleId);
//		});
//	}
//};
//App.SecurityManager.hasAuthority = function(authorityId) {
//	if (this.principal) {
//		return _.find(this.principal.authorities, function(userAuthority) {
//			return (userAuthority === authorityId);
//		}) != undefined;
//	}
//};
///*
// * 
// * log("loading data from authentication."); $.getJSON('login/authentication')
// * .done(function(response) { log(response);
// * Referrals.CacheManager.put("Referrals_Authentication", response);
// * Referrals.SecurityManager.principal = response; Referrals.advanceReadiness(); })
// * .fail(function(errors) { //TODO: redirect to application startup failure
// * page? log(errors); });
// */