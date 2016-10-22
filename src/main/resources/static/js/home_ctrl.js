
app.controller("HomeController", function($rootScope, $scope, $location, AppService) {
	$scope.getPath = function(path) {
		$location.path(path);
	}
	
	$rootScope.isAuthenticated("/dashboard");
});