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
  }

  ctrl.updatePrice = function() {
    ctrl.newItem = {
      itemID: ItemService.getIndex(ctrl.itemID, ctrl.storeID),
      itemPrice: ctrl.newPrice
    }

    $http({
      url: "http://localhost:8080/item/updateitem",
      method: "POST",
      headers: {'Content-Type' : 'application/json'},
      data: JSON.stringify(ctrl.newItem)
    }).then(function(response) {
      ItemService.updatePrice(ctrl.newItem.itemID, ctrl.newPrice);
      alert("Item has been updated.")
    }), function(){
      alert("This is broken");
    }
  }

  ctrl.findPrice = function() {
    console.log(ctrl.itemID + ctrl.storeID);;
    ItemService.getPrice(ctrl.itemID, ctrl.storeID);
  }
}
