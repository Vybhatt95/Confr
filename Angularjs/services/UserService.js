var app = angular.module('app');

app.service('UserService', function() {
    var ctrl = this;
    var currUser = {};

    ctrl.storeUser = function(user) {
        ctrl.currUser = user;
    }

    ctrl.getCurrentUserName = function() {
        return ctrl.currUser.username;
    }

    ctrl.getCurrentPassword = function() {
        return ctrl.currUser.password;
    }
})