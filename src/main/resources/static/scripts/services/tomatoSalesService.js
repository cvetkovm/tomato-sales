myApp.service('tomatoSalesService', ['$http', '$log', '$q', function($http, $log, $q) {

	this.getTomatoSales = function(numberOfTomatoSales) {
		var deferred = $q.defer();
		
		var tomatoUrl = null;
		if(angular.isUndefined(numberOfTomatoSales) || numberOfTomatoSales === null ) {
			tomatoUrl = '/data';
		} else {
			tomatoUrl = '/data?size=' + numberOfTomatoSales;
		}
		
		$http({
			method: 'GET',
			url: tomatoUrl
		}).then(function successCallback(response) {
			deferred.resolve({tomatoSales:response.data});
		}, function errorCallback(response) {
			deferred.reject({response});
		});
		return deferred.promise;
	}

}]);