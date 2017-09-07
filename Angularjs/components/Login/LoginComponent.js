var app = angular.module('app');

app.component('login', {
    templateUrl: 'components/Login/Login.html',
    controller: LoginController
})

function LoginController() {
    var ctrl = this;

    ctrl.message = "";
    ctrl.login = function($http, UserService) {
        ctrl.credentials = {
<<<<<<< HEAD

=======
>>>>>>> 738fd3030cdd256b427ffe1172f47734cdb0f1d6
            username: ctrl.username,
            password: ctrl.password
        }

        $http({
            url: '',
            method: 'Post',
            data: JSON.stringify(ctrl.credentials)
        }).then(function(response) {
            ctrl.message = response.data;
        }), function(response) {
<<<<<<< HEAD


=======
            ctrl.message = response.data;
>>>>>>> 738fd3030cdd256b427ffe1172f47734cdb0f1d6
        }
    }

}
