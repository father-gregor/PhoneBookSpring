
var app = angular.module("PhonebookApp", ["ngRoute"]);
app.config(function($routeProvider, $locationProvider) {
	$routeProvider
	.when("/", {
		templateUrl: "partials/home.html",
		controller: "EntryController"
	})
	.when("/register", {
		templateUrl: "partials/signup.html",
		controller: "RegisterController"
	});
	$locationProvider.html5Mode(true);
});