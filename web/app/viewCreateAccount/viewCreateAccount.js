'use strict';

angular.module('myApp.viewCreateAccount', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/CreateAccount', {
    templateUrl: 'app/viewCreateAccount/viewCreateAccount.html',
    controller: 'ViewCreateAccountCtrl',
    controllerAs : 'ctrl'
  });
}])

.controller('ViewCreateAccountCtrl', [function() {
        
}]);