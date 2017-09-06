var app = angular.module('app', ['ngMaterial','ngRoute', 'ngMessages']);

app.config(function($routeProvider) {
    $routeProvider
    .when("/", {
        template: '<login></login>'
    })
    .when("/home",{
        template: '<home></home>'
    })
<<<<<<< HEAD
=======
    .when("/register",{
        template: '<register></register>'
    })

});

app.controller("baseCtrl", function($scope){

>>>>>>> e18baaf547dc9d486b22d69d672795a2cce9b859
});
