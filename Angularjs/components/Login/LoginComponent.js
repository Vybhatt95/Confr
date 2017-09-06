var app = angular.module('app');

app.component('login', {
    templateUrl: 'components/Login/Login.html',
    controller: LoginController
})

function LoginController() {
    var ctrl = this;
    ctrl.message = "Controller";

    ctrl.$onInit = function() {
        console.log("something");
    }

    ctrl.login = function() {
        ctrl.credentials = {

        }
    }
}
