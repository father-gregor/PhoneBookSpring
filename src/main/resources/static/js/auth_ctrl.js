
app.controller("AuthController", function($rootScope, $scope, $location, AppService) {
	$scope.credentials = {};
	$scope.login = function() {
		if($scope.credentials.login.length > 0 ) {
			AppService.authenticateUser()
			.then(function(data) {
				if(data.name) {
					$rootScope.authenticated = true;
					$location.path("/");
				} else {
					$rootScope.authenticated = false;
					$location.path("/auth");
				}
			});
		}
	};
});