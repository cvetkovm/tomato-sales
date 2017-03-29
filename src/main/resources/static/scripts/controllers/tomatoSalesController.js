myApp.controller('tomatoSalesController', ['$scope', 'tomatoSalesService',
	                                function($scope, tomatoSalesService) {
	
	$scope.size = 3;
	
	$scope.getTomatoSales = function(numberOfSales){
		var promise = tomatoSalesService.getTomatoSales(numberOfSales);
		promise.then(function(result) {
			$scope.tomatoSales = result.tomatoSales;
		}, function(result) {
		});
	}

	$scope.getTomatoSales($scope.size);

}]);