'use strict';

angular.module('myApp.viewCompanyInfo', ['ngRoute'])

        .config(['$routeProvider', function ($routeProvider) {
                $routeProvider.when('/CompanyInfo', {
                    templateUrl: 'app/viewCompanyInfo/viewCompanyInfo.html',
                    controller: 'ViewCompanyInfoCtrl',
                    controllerAs: 'ctrl'
                });
            }])

        .controller('ViewCompanyInfoCtrl', ["$http", function ($http) {
                var self = this;
                self.message = "HELLO FROM THE OTheR SIIIIIIIDE!!";
                self.joni = "Joni ER Stadig bøsse.";

                

                self.getCompany = function () {
                    return $http({
                        method: 'GET',
                        url: 'https://cvrapi.dk/api?search=' + self.cvr + '&country=DK',
                        skipAuthorization: true,
                        contentType: "application/json"
                    }).success(function (data) {
                        self.company = data;
                        console.log(data);
                    }).
                            error(function (data) {
                            });
                };
            }]);


//    $http.get('api/demouser')
//        .success(function(data) {
//            self.data = data;
//    console.log(data);
//        })
//        .error(function(data) {
//        });