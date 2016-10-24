
app.controller("DashController", function($scope, $location, AppService, EntryService) {
	$scope.showModal = false;
	$scope.sortType = "name";
	$scope.sortReverse = false;
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
		console.log("1");
		if(entry.entryId !== null) {
			EntryService.setEntryId(entry.entryId);
			$location.path("/edit-entry/" + entry.entryId);
		}
	}
	$scope.removeEntry = function(entry) {
		if(entry !== null && entry !== undefined) {
			AppService.deleteEntry(entry.entryId)
			.then(function(resp) {
				$scope.getEntry();
			});
		}
		$scope.showModal = !$scope.showModal;
	}
	$scope.toggleModal = function(entry, $event) {
		$event.stopPropagation();
		$scope.entryToRemove = entry;
		$scope.showModal = !$scope.showModal;
	}
	$scope.closeModal = function() {
		$scope.showModal = false;
	}
	$scope.changeSortType = function(type) {
		if($scope.sortType === type)
			$scope.sortReverse = !$scope.sortReverse;
		else {
			$scope.sortType = type;
			$scope.sortReverse = false;
		}
	}
	$scope.isArrowUp = function(type) {
		return $scope.sortType === type && $scope.sortReverse;
	}
	$scope.isArrowDown = function(type) {
		return $scope.sortType === type && !$scope.sortReverse;
	}
 });