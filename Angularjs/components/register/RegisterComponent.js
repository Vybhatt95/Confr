var app = angular.module('app');

app.component('register',{ 
        templateUrl: 'components/register/register.html',
        controller: RegisterController
})

function RegisterController(){
    var ctrl = this;
    ctrl.user;
    ctrl.firstname;
    ctrl.lastname;
    ctrl.username;
    ctrl.password;
    ctrl.confirm;
    ctrl.email;
    
    ctrl.createUser = function(){
        $http({
            url: '.../register',
            method: 'POST',
            headers: {'Content-Type' : 'application/json'},
            data: {
                "firstname": ctrl.username,
                "lastname":  ctrl.lastname,
                "username": ctrl.username,
                "password": ctrl.password,
                "email": ctrl.email
            }
        }).then(function(response){

        }, function(response){

        })
    }
}