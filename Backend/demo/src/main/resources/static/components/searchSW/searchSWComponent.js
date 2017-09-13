var app = angular.module('app');

app.component('searchSw',{
    templateUrl: 'components/searchSW/search-sw.html',
    controller: searchSWController
})

function searchSWController(){
  var ctrl = this;
  ctrl.newPrice = 2.00;
  ctrl.itemList = ["Apples", "Bananas", "Oranges"];
  ctrl.storeList = ["Walmart", "Harris Teeter"];

  ctrl.$onInit = function() {
      console.log("Hello");
  }

  ctrl.print = function(){
    console.log("Hello form the print functions");
  }

  ctrl.updatePrice = function() {
    ctrl.newItem = {

    }
  }

  ctrl.findPrice = function() {
    console.log("gets here");
    if(ctrl.itemList.indexOf(ctrl.itemID) == 0) {
      ctrl.newPrice = 1.50;
    } else {
      ctrl.newPrice = 5.25;
    }
  }
}
