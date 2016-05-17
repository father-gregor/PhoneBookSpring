
var app = angular.module("PhonebookApp", ["ngRoute"]);
app.config(function($routeProvider, $locationProvider) {
	$routeProvider
	.when("/", {
		templateUrl: "partials/home.html",
		controller: "HomeController"
	})
	.when("/register", {
		templateUrl: "partials/signup.html",
		controller: "RegisterController"
	})
	.when("/auth", {
		templateUrl: "partials/auth.html",
		controller: "AuthController"
	});
	$locationProvider.html5Mode(true);
});