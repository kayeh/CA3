'use strict';

angular.module('myApp.viewDocumentation', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/Documentation', {
    templateUrl: 'app/viewDocumentation/viewDocumentation.html',
    controller: 'ViewDocumentationCtrl',
    controllerAs : 'ctrl'
  });
}])

.controller('ViewDocumentationCtrl', [function() {
  var self = this;
   self.message = "HELLO FROM THE OTheR SIIIIIIIDE!!";
   self.joni = "Joni er bøsse.";
}]);