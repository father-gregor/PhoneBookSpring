
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
	})
	.when("/create-entry", {
		templateUrl: "partials/create.html",
		controller: "CreationController"
	})
	.when("/edit-entry/:entryId", {
		templateUrl: "partials/edit.html",
		controller: "EditController"
	});
	$locationProvider.html5Mode(true);
});
app.run(function($rootScope, AppService) {
	
});
app.service("EntryService", function() {
	var entry = {
		id: null	
	};
	return {
		setEntryId: function(id) {
			entry.id = id;
		},
		getEntryId: function() {
			return entry.id;
		}
	}
});
app.controller("AppController", function($rootScope, $scope, $location, AppService) {
	$rootScope.logout = function() {
		AppService.logout()
		.then(function() {
			$rootScope.authenticated = false;
			$location.path("/auth");
		})
	};
	$rootScope.isAuthenticated = function(path) {
		AppService.isAuthenticated()
		.then(function(data) {
			if(data === null || data === undefined) {
				console.log("undef");
				$rootScope.authenticated = false;
			} else if(data.user !== null && data.user !== undefined) {
				$rootScope.authenticated = true;
				console.log(path);
				if(path !== undefined)
					$location.path(path);
			}
			$rootScope.showPage = true;
		});
	}
	$rootScope.isAuthenticated();
	
});