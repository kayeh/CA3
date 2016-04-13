'use strict';

angular.module('myApp.viewAllUsers', ['ngRoute'])

        .config(['$routeProvider', function ($routeProvider) {
                $routeProvider.when('/AllUsers', {
                    templateUrl: 'app/viewAllUsers/viewAllUsers.html',
                    controller: 'ViewAllUsersCtrl',
                    controllerAs: 'ctrl'
                });
            }])

        .controller('ViewAllUsersCtrl', ["$http", function ($http) {
                var self = this;
                self.message = "HELLO FROM THE OTheR SIIIIIIIDE!!";
                self.joni = "Joni er en mand. Joni kan godt lide mænd. Ergo er Joni en bøsse.";

                self.getAllUsers = function () {
                    return $http({
                        method: 'GET',
                        url: "api/admin/users",
                        contentType: "application/json"
                    }).success(function (data) {
                        self.users = data;
                        console.log(data);
                    }).error(function (data) {

                    });
                };

            }]);