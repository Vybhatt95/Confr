var app = angular.module('app');

app.component('createlistSw', {
    templateUrl: 'components/createList/createlist-sw.html',
    controller: createListController
})

function createListController(){
      var ctrl = this;

      ctrl.products = []

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

      ctrl.addItem = function(val){
          console.log(ctrl.val);
          ctrl.products.push({"itemname":ctrl.val});

      }

}
