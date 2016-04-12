'use strict';

angular.module('myApp.viewCreateAccount', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/CreateAccount', {
    templateUrl: 'app/viewCreateAccount/viewCreateAccount.html',
    controller: 'ViewCreateAccountCtrl',
    controllerAs : 'ctrl'
  });
}])

.controller('ViewCreateAccountCtrl', ["$http", "$location", function($http, $location) {
        var self = this;

        self.createUser = function(){
          
            $http.post("api/create/create", self.user).success(function(){
                console.log(self.user);
               self.user = {};
               $location.path("/app/viewHome.html");
            });
        };
}]);