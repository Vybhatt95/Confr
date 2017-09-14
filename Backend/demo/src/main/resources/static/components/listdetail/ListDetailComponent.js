var app = angular.module('app');

app.component('listdetail',{
    templateUrl: "components/listdetail/listdetail.html",
    controller: ListDetailController
})

function ListDetailController(ListService,ItemService){
    var ctrl = this;
    ctrl.itemList = ItemService.itemNames;
    ctrl.storeList = ItemService.storeNames;
    
    ctrl.list = ListService.lists;
     console.log(ctrl.list[0].listName);
    // ctrl.items = ctrl.list[0].items[0];
    // console.log("YOOO");
    //
    // console.log(ctrl.items);
    ctrl.listItems = ctrl.list["0"].items;

    console.log(ctrl.listItems[0]);






    // ctrl.products =["Milk", "Bread", "Cheese"];
    ctrl.addItem = function(val){
        console.log(ctrl.val);
        ctrl.products.push({"itemname":ctrl.val});

    }


}
