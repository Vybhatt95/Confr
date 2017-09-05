var app = angular.module('app');

app.component('register',{ 


        template: '../views/register.html',
        controller: function(){
            $scope.user;
            $scope.firstname;
            $scope.lastname;
            $scope.username;
            $scope.password;
            $scope.confirm;
            $scope.email;
            
            var createUser = function(){
                $http({
                    url: '.../register',
                    method: 'POST',
                    headers: {'Content-Type' : 'application/json'},
                    data: {
                        "firstname": $scope.username,
                        "lastname":  $scope.lastname,
                        "username": $scope.username,
                        "password": $scope.password,
                        "email": $scope.email
                    }
                }).then(function(response){

                }, function(response){

                })
            }
        }


})