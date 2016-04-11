'use strict';

// Declare app level module which depends on views, and components
angular.module('myApp', [
  'ngRoute',
  'ngAnimate',
  'angular-jwt',
  'ui.bootstrap',
  'myApp.security',
  'myApp.viewHome',
//  'myApp.view2',
//  'myApp.view3',
//  'myApp.view4',
  'myApp.viewDocumentation',
  'myApp.viewCompanyInfo',
  'myApp.viewExchangeRateInfo',
  'myApp.viewAllUsers',
  'myApp.filters',
  'myApp.directives',
  'myApp.factories',
  'myApp.services'
]).
config(['$routeProvider', function($routeProvider) {
  $routeProvider.otherwise({redirectTo: '/Home'});
}])
//.
        .config(function ($httpProvider) {
   $httpProvider.interceptors.push('AuthInterceptor');
});


