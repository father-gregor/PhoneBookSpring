
app.controller("HomeController", function($scope, $location) {
	$scope.getPath = function(path) {
		$location.path(path);
	}
});