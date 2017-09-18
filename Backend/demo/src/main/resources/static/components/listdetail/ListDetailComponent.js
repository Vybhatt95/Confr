var app = angular.module('app');

app.component('listdetail',{
    templateUrl: "components/listdetail/listdetail.html",
    controller: ListDetailController
})

function ListDetailController(ListService,ItemService, $routeParams){
    var ctrl = this;
    ctrl.itemList = ItemService.itemNames;
    ctrl.storeList = ItemService.storeNames;

    ctrl.list = ListService.lists;

    ctrl.listName_ = ctrl.list[$routeParams.index].listName;

    ctrl.listItems = ctrl.list[$routeParams.index].items;





      console.log(ctrl.list[$routeParams.index].items);
      console.log(ctrl.list[$routeParams.index].items[$routeParams.index]);
      console.log(ctrl.list[$routeParams.index].items[$routeParams.index].stores);





    ctrl.addItem = function(val){
        console.log(ctrl.val);
        ctrl.products.push({"itemname":ctrl.val});

    }


}
