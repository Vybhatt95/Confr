var app = angular.module('app');

app.service('UserService', function() {
    var ctrl = this;
    ctrl.currUser = {
    };

    ctrl.storeUser = function(user) {
        ctrl.currUser = user;
    }

    ctrl.getCurrentUserName = function() {
        return ctrl.currUser.userName;
    }

    ctrl.getCurrentPassword = function() {
        return ctrl.currUser.passWord;
    }
})