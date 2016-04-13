'use strict';

// Declare app level module which depends on views, and components
angular.module('myApp', [
  'ngRoute',
  'ngAnimate',
  'angular-jwt',
  'ui.bootstrap',
  'myApp.security',
  'myApp.viewHome',
  'myApp.viewDocumentation',
  'myApp.viewCompanyInfo',
  'myApp.viewExchangeRateInfo',
  'myApp.viewCreateAccount',
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


