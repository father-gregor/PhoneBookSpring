
app.controller("CreationController", function($scope, $rootScope, $location, AppService) {
	$scope.entry = {}
	//$scope.phoneRegex = "\\+38\([0-9]{3}\)[0-9]{3}-[0-9]{2}-[0-9]{2}";
	$scope.phoneRegex = "\\([0-9]{3}\\)[0-9]{3}-[0-9]{2}-[0-9]{2}";
	$scope.create = function() {
		if($scope.entry_form.$valid) {
			AppService.sendNewEntry($scope.entry)
			.then(function(resp) {
				$location.path(resp.data);
				//console.log(resp);
			});
		}
	}
	$scope.hasError = function(field) {
		return $scope.entry_form[field].$invalid && $scope.entry_form.$submitted;
	}
	$scope.hasSuccess = function(field) {
		return $scope.entry_form[field].$valid && $scope.entry_form.$submitted;
	}
});