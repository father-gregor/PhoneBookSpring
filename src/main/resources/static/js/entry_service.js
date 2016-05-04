
app.factory("EntryService", function($http, $q) {
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
		}
	};
});