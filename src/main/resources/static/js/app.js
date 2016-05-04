
var app = angular.module("PhonebookApp", ["ngRoute"]);
app.config(["$routeProvider", function($routeProvider) {
	$routeProvider
	.when("/", {
		templateUrl: "/index",
		controller: "EntryController"
	});
}]);