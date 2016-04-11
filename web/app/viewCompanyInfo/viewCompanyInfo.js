'use strict';

angular.module('myApp.viewCompanyInfo', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/CompanyInfo', {
    templateUrl: 'app/viewCompanyInfo/viewCompanyInfo.html',
    controller: 'ViewCompanyInfoCtrl',
    controllerAs : 'ctrl'
  });
}])

.controller('ViewCompanyInfoCtrl', [function() {
  var self = this;
   self.message = "HELLO FROM THE OTheR SIIIIIIIDE!!";
   self.joni = "Joni ER Stadig bøsse.";
}]);