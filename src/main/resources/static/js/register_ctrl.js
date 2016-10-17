
app.controller("RegisterController", function($scope, $location, AppService) {
	$scope.user = {
		username: null,
		email: null,
		password: null,
		passConf: null,
		realName: null,
		realFather: null,
		realSurname: null
	};
	$scope.send = function() {
		if($scope.form.$valid && $scope.isPassMatch()) {
			var endUser = {
				login: $scope.user.username,
				password: $scope.user.password,
				fio: $scope.user.realName + " " + $scope.user.realFather + " " + $scope.user.realSurname
			};
			AppService.registerUser(endUser)
			.then(function(data) {
				console.log(data);
				$location.path(data);
			}, function(err) {
				console.log("Error");
				console.log(err);
			});
		}
		//$scope.submitted = true;
		console.log($scope.user);
	};
	$scope.hasFormError = function() {
		return $scope.form.$invalid & $scope.submitted;
	}
	$scope.hasError = function(field, valid) {
		return $scope.form[field].$invalid && $scope.form.$submitted;
	}
	$scope.isPassMatch = function() {
		return $scope.user.password === $scope.user.passConf;
	}
	$scope.getPath = function() {
		//$location.path(path);
		console.log("Work");
	}
});