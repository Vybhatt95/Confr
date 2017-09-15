var app = angular.module('app');

app.component('listSw',{
    templateUrl: "components/list/list-sw.html",
    controller: ListController
})

function ListController(listObj,$location,ListService){
    var ctrl = this;

    ctrl.list = ListService.lists;



    ctrl.getCompleteList = function(item, index){
        listObj.setObj(index);
        console.log(index);
        $location.path('/listdetail').search({index: index})
    }




}
