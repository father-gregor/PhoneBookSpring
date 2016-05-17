
app.factory("EntryService", function($http, $q, $location) {
	return {
		createEntry: function(entry) {
			return $http.get("/create-entry", entry)
			.then(
					function(response) {
						return response.data;
					},
					function(err) {
						console.log("Error while creating");
						return $q.reject(err);
					}
			);
		},
		registerUser: function(user) {
			return $http.post("/register-user", user)
			.then(
					function(response) {
						return response.data;
					},
					function(err) {
						return $q.reject(err);
					}
			);
		}
	};
});