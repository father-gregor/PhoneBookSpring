
app.controller("DashController", function($scope, $location, AppService, EntryService) {
	$scope.getEntry = function() {
		AppService.getEntry()
		.then(function(resp) {
			if(resp.data.length > 0) {
				console.log(resp.data);
				$scope.entries = resp.data;
			}
		});
	}
	$scope.getEntry();
	$scope.getPath = function(path) {
		$location.path(path);
	}
	$scope.openEntry = function(entry) {
		if(entry.entryId !== null) {
			EntryService.setEntryId(entry.entryId);
			$location.path("/edit-entry/" + entry.entryId);
		}
	}
 });