
app.factory("AppService", function($http, $q, $location) {
	return {
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
		},
		isAuthenticated: function() {
			return $http.get("/authenticated")
			.then(
					function(response) {
						return response.data;
					},
					function(err) {
						return $q.reject(err);
					}
			);
		},
		logout: function() {
			return $http.post("logout", {})
			.then(
					function(response) {
						return response;
					},
					function(err) {
						return $q.reject(err);
					}
			);
		},
		getEntry: function() {
			return $http.get("/getentry")
			.then(
					function(response) {
						return response;
					},
					function(err) {
						return $q.reject(err);
					}
			);
		},
		sendNewEntry: function(entry) {
			return $http.post("/newentry", entry)
			.then(
					function(response) {
						return response;
					},
					function(err) {
						return $q.reject(err);
					}
			);
		},
		getEntryById: function(id) {
			return $http.get("/get-entry-" + id)
			.then(
					function(response) {
						console.log("ffffeeee");
						return response;
					},
					function(err) {
						console.log("1111111111");
						return $q.reject(err);
					}
			);
		},
		updateEntry: function(entry) {
			return $http.put("/update-entry", entry)
			.then(
					function(response) {
						return response;
					},
					function(err) {
						return $q.reject(err);
					}
			);
		},
		deleteEntry: function(entryId) {
			return $http.delete("/delete-entry-" + entryId, entryId)
			.then(
					function(response) {
						return response;
					},
					function(err) {
						return $q.reject(err);
					}
			);
		}
	};
});