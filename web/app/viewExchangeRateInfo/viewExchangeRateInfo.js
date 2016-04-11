'use strict';

angular.module('myApp.viewExchangeRateInfo', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/ExchangeRateInfo', {
    templateUrl: 'app/viewExchangeRateInfo/viewExchangeRateInfo.html',
    controller: 'ViewExchangeRateInfoCtrl',
    controllerAs : 'ctrl'
  });
}])

.controller('ViewExchangeRateInfoCtrl', [function() {
  var self = this;
   self.message = "HELLO FROM THE OTheR SIIIIIIIDE!!";
   self.joni = "Joni === bøsse.";
}]);