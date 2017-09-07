var app = angular.module('app');

app.component('login', {
    templateUrl: 'components/Login/Login.html',
    controller: LoginController
})

function LoginController() {
    var ctrl = this;

    ctrl.login = function($http) {
        ctrl.credentials = {

            username: ctrl.username,
            password: ctrl.password
        }

        $http({
            url: '',
            method: 'Post',
            data: JSON.stringify(ctrl.credentials)
        }).then(function(response) {

        }), function(response) {


        }
    }
}
