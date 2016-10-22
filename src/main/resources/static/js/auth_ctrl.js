
app.controller("AuthController", function($rootScope, $scope, $location, AppService) {
	
	$rootScope.isAuthenticated("/dashboard");
});