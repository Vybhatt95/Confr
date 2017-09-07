var app = Angular.module('app');

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