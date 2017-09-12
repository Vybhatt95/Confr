var app = angular.module('app');

app.component('listdetail',{
    templateUrl: "components/listdetail/listdetail.html",
    controller: ListDetailController
})

function ListDetailController(){
    var ctrl = this;


    ctrl.products = [{
      "itemname": "Milk"
    },
    {
      "itemname": "Apple"
    },
    {
      "itemname": "Ice-Cream"
    },
    {
      "itemname": "Nuts"
    }]

    //extra list to add to autocomplete
    ctrl.productsToAdd = [{
      "itemname": "Mango"
    },
    {
      "itemname": "Carrot"
    },
    {
      "itemname": "Peanut Butter"
    },
    {
      "itemname": "Jelly"
    }]
    ctrl.listtitle = "Trial";
    console.log(ctrl.listtitle);
    // ctrl.products =["Milk", "Bread", "Cheese"];
    ctrl.addItem = function(val){
        console.log(ctrl.val);
        ctrl.products.push({"itemname":ctrl.val});

    }


}
