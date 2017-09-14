var app = angular.module('app');

app.component('changePass', {
    templateUrl: '/components/changePassword/changePassword.html',
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
            console.log("this worked");
            ctrl.updatedPassword = {
                passWord: ctrl.newPassword
            }

            $http({
                url: 'http://localhost:8080/users/password',
                method: "POST",
                data: JSON.stringify(ctrl.updatedPassword)
            }).then(function(response) {
                alert("Password Changed");
                setTimeout(function() {
                    $mdDialog.hide();
                }, 100);
            }, function(response) {
                console.log("request failed");
            })
        } else {
            ctrl.message = "Incorrect Password. Try Again."
        }

    }
  
    ctrl.cancel = function() {
      $mdDialog.cancel();
    }
  }