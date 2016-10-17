
var app = angular.module("PhonebookApp", ["ngRoute"]);
app.config(function($routeProvider, $locationProvider) {
	$routeProvider
	.when("/", {
		templateUrl: "partials/home.html",
		controller: "HomeController"
	})
	.when("/register", {
		templateUrl: "partials/register.html",
		controller: "RegisterController"
	})
	.when("/auth", {
		templateUrl: "partials/auth.html",
		controller: "AuthController"
	})
	.when("/dashboard", {
		templateUrl: "partials/dashboard.html",
		controller: "DashController"
	});
	$locationProvider.html5Mode(true);
});