var app = angular.module('app');

app.component('createlistSw', {
    templateUrl: 'components/createList/createlist-sw.html',
    controller: createListController
})

function createListController($http, ItemService, ListService, $location){
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



      ctrl.hasChanged = function (itemID){
        console.log(itemID);
          ctrl.priceStore=[];
        for(var i =0; i<ctrl.storeList.length; i++){
        ctrl.priceStore.push({"storeName": ctrl.storeList[i], "itemPrice" : ItemService.getPrice(itemID, ctrl.storeList[i])} );

        }

        console.log(ctrl.priceStore);
      }

      ctrl.findPrice = function() {
        console.log(ctrl.itemID + ctrl.storeID);;
        ctrl.newPrice = ItemService.getPrice(ctrl.itemID, ctrl.storeID);
      }

      ctrl.listTitle;
      ctrl.addItem = function(itemName, storeID, listName){
          ctrl.listTitle = listName;
          ctrl.products.push({

            "itemId" : ItemService.getIndex(itemName, storeID.storeName),
            "itemName": itemName,
            "itemPrice": storeID.itemPrice,
            "barcode": 0,
            "stores": {
                  "storeName" : storeID.storeName
            }

        });

      }

      ctrl.printList = function(){
        console.log(ctrl.products);
      }


        ctrl.getTotal = function(){
        ctrl.getTotalPrice = 0;
        for(var i=0; i<ctrl.products.length;i++){
            ctrl.getTotalPrice+= ctrl.products[i].itemPrice;

        }
        console.log(ctrl.getTotalPrice);
      }




      ctrl.saveList = function(listName){
        ctrl.data={
            "listName" : listName,
            "listTotal" : ctrl.getTotalPrice,
            "items" : ctrl.products

        }


        console.log(ctrl.data);

          //Get total of the list:
      $http.post('http://localhost:8080/lists/new',JSON.stringify(ctrl.data))
          .then(function(response){
            if(response.data){
              console.log(response.data)
              ListService.addList(ctrl.data);

            }
            else{
              console.log("bad errros")
            }
          })

      }

}
