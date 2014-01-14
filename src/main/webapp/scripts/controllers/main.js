'use strict';

angular.module('yomanApp')
  .controller('MainCtrl', function ($scope, Restangular) {
	  Restangular.one("user").get().then( function(user) {
	       $scope.user = user; 
	    });
  });
