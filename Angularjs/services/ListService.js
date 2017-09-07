var app = angular.module('app');

app.service('ListService', function() {
    var ctrl = this;

    ctrl.lists = [];

    ctrl.addList = function(list) {
        ctrl.lists.push(list);
    }

    ctrl.deleteList = function(index) {
        if(index >= 0) {
            ctrl.lists.splice(index, 1);
        }
    }
})

app.service('listObj',function(){
    var ctrl = this;

    ctrl.obj = null;

    ctrl.getObj = function(){
        return ctrl.obj
    }
    ctrl.setObj = function(o){
        ctrl.obj = o
    }
})