var app = angular.module('app', ['ngMaterial','ngRoute', 'ngMessages']);

app.config(function($routeProvider) {
    $routeProvider
    .when("/", {
        template: '<login></login>'
    })
    .when("/home",{
        template: '<home></home>'
    })

    .when("/register",{
        template: '<register></register>'
    })


});

app.controller("baseCtrl", function($scope){

});
