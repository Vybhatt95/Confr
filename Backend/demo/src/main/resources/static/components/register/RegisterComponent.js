var app = angular.module('app');

app.component('register',{ 
        templateUrl: 'components/register/register.html',
        controller: RegisterController
})

function RegisterController($location, $http){
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
            url: 'http://localhost:8080/users/register',
            method: 'POST',
            headers: {'Content-Type' : 'application/json'},
            data: {
                "firstName": ctrl.username,
                "lastName":  ctrl.lastname,
                "userName": ctrl.username,
                "passWord": ctrl.password,
                "email": ctrl.email
            }
        }).then(function(response){
            alert("Your account was sucessfully registered. Returning to Login.");
            $location.path("/");
        }, function(response){
            alert("Your username or email has already been taken. Try Again.");
        })
    }

    ctrl.back = function(){
        $location.path("/");
    }
}