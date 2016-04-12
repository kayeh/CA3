'use strict';

angular.module('myApp.viewCreateAccount', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/CreateAccount', {
    templateUrl: 'app/viewCreateAccount/viewCreateAccount.html',
    controller: 'ViewCreateAccountCtrl',
    controllerAs : 'ctrl'
  });
}])

.controller('ViewCreateAccountCtrl', ["$http", function($http) {
        var self = this;

        self.createUser = function(){
            $http.post("api/create/create", self.user).success(function(){
               self.user = {};
               alert("User created!");
            }).error(function(){
                alert("ERROR");
            });
        };
}]);