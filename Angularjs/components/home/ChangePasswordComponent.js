var app = angular.module('app');

app.component('changePass', {
    templateUrl: '/components/home/changePassword.html',
    controller: ChangePasswordController
})

function ChangePasswordController($mdDialog, UserService, $http) {
    var ctrl = this;
    ctrl.message = "";
    
    ctrl.$onInit = function() {
      console.log("heyo");
    }

    ctrl.change = function() {
        console.log("watup");

        if(UserService.getCurrentPassword() == ctrl.oldPassword) {
            ctrl.updatedPassword = {
                passWord: ctrl.newPassword
            }

            $http({
                url: 'localhost:8080/users/password',
                method: "POST",
                data: JSON.stringify(ctrl.updatedPassword)
            }).then(function(response) {
                alert(response.data);
                setTimeout(function() {
                    $mdDialog.hide();
                }, 1000);
            }, function(response) {
                console.log("request failed");
                ctrl.message = response.data;
            })
        } else {
            ctrl.message = "Incorrect Password. Try Again."
        }

    }
  
    ctrl.cancel = function() {
      $mdDialog.cancel();
    }
  }