
app.controller("HomeController", function($rootScope, $scope, $location) {
	$rootScope.authenticated = false;
	$scope.getPath = function(path) {
		$location.path(path);
	}
});