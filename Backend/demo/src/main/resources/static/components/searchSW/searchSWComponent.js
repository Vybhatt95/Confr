var app = angular.module('app');

app.component('searchSw',{
    templateUrl: 'components/searchSW/search-sw.html',
    controller: searchSWController
})

function searchSWController($http, ItemService){
  var ctrl = this;
  ctrl.newPrice = 0.00;
  ctrl.itemList = ItemService.itemNames;
  ctrl.storeList = ItemService.storeNames;


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
        console.log(ctrl.itemList);
        console.log(ctrl.storeList);
        console.log("All Items Processed");
      }), function() {
        console.log("This method is a failure");
      }
    }
  }

  ctrl.updatePrice = function() {
    ctrl.newItem = {
      itemId: ItemService.getIndex(ctrl.itemID, ctrl.storeID),
      itemPrice: parseFloat(ctrl.newPrice)
    }

    $http({
      url: "http://localhost:8080/item/updateitem",
      method: "POST",
      headers: {'Content-Type' : 'application/json'},
      data: JSON.stringify(ctrl.newItem)
    }).then(function(response) {
      ItemService.updatePrice(ctrl.newItem.itemId, parseFloat(ctrl.newPrice));
      ctrl.itemList = ItemService.itemNames;
      ctrl.storeList = ItemService.storeNames;
      alert("Item has been updated.")
    }), function(){
      alert("This is broken");
    }
  }

  ctrl.findPrice = function() {
    console.log(ctrl.itemID + ctrl.storeID);;
    ctrl.newPrice = parseFloat(Math.round(ItemService.getPrice(ctrl.itemID, ctrl.storeID) * 100) / 100).toFixed(2);
  }
}
