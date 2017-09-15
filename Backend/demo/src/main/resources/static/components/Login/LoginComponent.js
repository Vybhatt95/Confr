var app = angular.module('app');

app.component('login', {
    templateUrl: 'components/Login/Login.html',
    controller: LoginController
})

function LoginController($http, $location, UserService, ListService) {
    var ctrl = this;

    ctrl.message = "";
    ctrl.login = function() {
        ctrl.credentials = {
            userName: ctrl.username,
            passWord: ctrl.password
        }

        $http.post('http://localhost:8080/users/login',JSON.stringify(ctrl.credentials)).then(function(response){
              if(response.data){
                if(response.data != null){
                  console.log(response.data);
                  UserService.storeUser(response.data);
                  ListService.lists = response.data.lists
                  $location.path('/home');
                }
                else{
                  $location.path('/');
                  ctrl.message = "Invalid Username or Password"
                }
              }
              else {

                 ctrl.message = "Invalid Username or Password"
                console.log("No response from host")
              }
        });
    };
};
