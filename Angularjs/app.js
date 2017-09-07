var app = angular.module('app', ['ngMaterial','ngRoute', 'ngMessages', 'ng-fusioncharts']);

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
    .when("/graphs",{
        template: '<analysis></analysis>'
    })
    .when("/list",{
        template: '<list></list>'
    })
    .when("/listdetail",{
        template: '<listdetail></listdetail>'
    })


});

app.controller("baseCtrl", function($scope){

});
