var app = angular.module('app');

app.component('listSw',{
    templateUrl: "components/list/list-sw.html",
    controller: ListController,
    bindings: {
        onAddList: "&"
    }
})

function ListController(listObj,$location,ListService, $http){
    var ctrl = this;

    ctrl.message = "";
    ctrl.list = ListService.lists;

    ctrl.removeList = function(list) {
        $http({
            url: "http://localhost:8080/lists/remove",
            method: "POST",
            data: list
        }).then(function(response) {
            console.log("Removing list " + list.listName);
            console.log("response.data");;
            ctrl.message = list.listName + "was removed";
            ListService.deleteList(list);
            ctrl.list= ListService.lists;
        }), function(response) {
            console.log("this sucks");
        }
    }

    ctrl.getCompleteList = function(l){
        listObj.setObj(l);
        $location.path('/listdetail')
    }
    
    ctrl.goCreate = function() {
        ctrl.onAddList();
    }
}
