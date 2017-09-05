var app = angular.module('app', ['ngMaterial','ngRoute', 'ngMessages']);

app.config(function($routeProvider) {
    $routeProvider
    .when("/", {
        template: '<login></login>'
    })

});
