var myApp = angular.module('myApp', ['ngRoute']);

myApp.config(function ($routeProvider) {

	$routeProvider
	.when('/', {
		templateUrl: 'pages/tomato-sales-list.html',
		controller: 'tomatoSalesController'
	})

	.when('/404', {
		templateUrl: 'pages/not_found.html',
	})

});


