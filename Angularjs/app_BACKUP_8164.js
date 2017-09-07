var app = angular.module('app', ['ngMaterial','ngRoute', 'ngMessages', 'ng-fusioncharts']);

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
>>>>>>> 738fd3030cdd256b427ffe1172f47734cdb0f1d6
    .when("/register",{
        template: '<register></register>'
    })
    .when("/graphs",{
        template: '<analysis></analysis>'
    })


});

app.controller("baseCtrl", function($scope){

});
