
app.controller("EditController", function($scope, $rootScope, $location, $routeParams, AppService, EntryService) {
	$scope.readOnly = true;
	$scope.getEntry = function() {
		var id = $routeParams.entryId;
		AppService.getEntryById(id)
		.then(function(resp) {
			if(resp.data !== null) {
				console.log(resp.data);
				$scope.entry = resp.data;
				$scope.entryReceived = true;
			}
		},
		function errorHandler1(error) {
			$location.path("/dashboard");
		});
	}
	$scope.getEntry();
	$scope.hasError = function(field) {
		return $scope.entry_form[field].$invalid && $scope.entry_form.$submitted;
	}
	$scope.hasSuccess = function(field) {
		return $scope.entry_form[field].$valid && $scope.entry_form.$submitted;
	}
	$scope.allowEdit = function() {
		$scope.readOnly = false;
	}
	$scope.updateEntry = function() {
		if($scope.entry_form.$valid) {
			AppService.updateEntry($scope.entry)
			.then(function(resp) {
				$location.path("/dashboard");
			});
		}
	}
});