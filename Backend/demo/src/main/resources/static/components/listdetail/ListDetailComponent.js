var app = angular.module('app');

app.component('listdetail',{
    templateUrl: "components/listdetail/listdetail.html",
    controller: ListDetailController
})

function ListDetailController(ListService){
    var ctrl = this;


    ctrl.list = ListService.lists;

    ctrl.items = ctrl.list[0].items[0];
    console.log("YOOO");

    console.log(ctrl.items.itemName);



    // ctrl.products =["Milk", "Bread", "Cheese"];
    ctrl.addItem = function(val){
        console.log(ctrl.val);
        ctrl.products.push({"itemname":ctrl.val});

    }


}
