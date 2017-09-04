var app = angular.module('app', ['ngMaterial','ngRoute']);

app.config(function($routeProvider) {
    $routeProvider
    .when("/", {
        templateUrl : "views/signin.html"
    })

});

app.controller("baseCtrl", function($scope){

});
