var app = angular.module('app');

app.component('login', {
    templateUrl: 'components/Login/Login.html',
    controller: LoginController
})

function LoginController($http, $location) {
    var ctrl = this;

    ctrl.message = "";
    ctrl.login = function() {
        ctrl.credentials = {
            username: ctrl.username,
            password: ctrl.password
        }

<<<<<<< HEAD
        $http({
            url: '',
            method: 'Post',
            data: JSON.stringify(ctrl.credentials)
        }).then(function(response) {
            ctrl.message = response.data;
        }), function(response) {

            ctrl.message = response.data;

        }
=======
        console.log("hello");
        $location.path('/home');

        // $http({
        //     url: '',
        //     method: 'Post',
        //     data: JSON.stringify(ctrl.credentials)
        // }).then(function(response) {
        //     ctrl.message = response.data;
        // }), function(response) {
        //     ctrl.message = response.data;
        // }
>>>>>>> da007ed0d1d47130f8e5c40bd0b07e734ca7ddd2
    }

}
