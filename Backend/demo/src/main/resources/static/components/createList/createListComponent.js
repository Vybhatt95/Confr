var app = angular.module('app');

app.component('createlistSw', {
    templateUrl: 'components/createList/createlist-sw.html',
    controller: createListController
})

function createListController($http, ItemService){
      var ctrl = this;

      ctrl.newPrice = 0.00;
      ctrl.itemList = ItemService.itemNames;
      ctrl.storeList = ItemService.storeNames;

      ctrl.products = []
      console.log("CREATELISTCONTROLLER");
      console.log(ctrl.storeList);

      ctrl.$onInit = function() {
        console.log("Hello");


        if(ItemService.inventory.length <= 0) {
          console.log("Sending Request");
          $http({
            url: "http://localhost:8080/item/all",
            method: "GET",
            headers: {'Content-Type' : 'application/json'}
          }).then(function(response) {
            ItemService.storeInventory(response.data);
            console.log("All Items Processed");
          }), function() {
            console.log("This method is a failure");
          }
        }


      }

      ctrl.findPrice = function() {
        console.log(ctrl.itemID + ctrl.storeID);;
        ctrl.newPrice = ItemService.getPrice(ctrl.itemID, ctrl.storeID);
      }


      ctrl.addItem = function(val){
          console.log(val);
          ctrl.products.push({"itemname": val});
      }

      ctrl.saveList = function(){
          //Get total of the list:


        ctr.listToSend = {
          "listId" : 1,
          "listName" : ctrl.listName,
          "listTotal" : 500,
          "items" : ctrl.products
        }

          // $http.post('http://localhost:8080/lists/new',JSON.stringify(ctrl.listToSend))
          //     .then(function(response){
          //       if(response.data){
          //         console.log(response.data)
          //       }
          //     })

      }

}
