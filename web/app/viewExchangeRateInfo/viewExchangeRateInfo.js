'use strict';

angular.module('myApp.viewExchangeRateInfo', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/ExchangeRateInfo', {
    templateUrl: 'app/viewExchangeRateInfo/viewExchangeRateInfo.html',
    controller: 'ViewExchangeRateInfoCtrl',
    controllerAs : 'ctrl'
  });
}])

.controller('ViewExchangeRateInfoCtrl', ["$http", function($http) {
  var self = this;
   self.message = "HELLO FROM THE OTheR SIIIIIIIDE!!";
   self.joni = "Joni === bøsse.";
  self.a = "";
  self.b = "";
  self.c = "";
   
  self.getDailyRates = function(){
      return $http({
          method: 'GET',
          url: 'api/currency/dailyrates',
          content: "application/json"
      }).success(function (data){
          console.log(data);
          self.rates = data;
      })
  }
   self.result = function(){
      return $http({
          method: 'GET',
          url: 'api/currency/calculator/' + self.a + "/" + self.b + "/" + self.c,
          content: "application/json"
      }).success(function (data){
          console.log(data);
          self.results = data;
      })
  }
  
  
}]);
