var app = angular.module('app');

app.component('listdetail',{
    templateUrl: "components/listdetail/listdetail.html",
    controller: ListDetailController
})

function ListDetailController(ListService,ItemService, $routeParams, $http){
    var ctrl = this;
    ctrl.itemList = ItemService.itemNames;
    ctrl.storeList = ItemService.storeNames;

    ctrl.list = ListService.lists;

    ctrl.listName_ = ctrl.list[$routeParams.index].listName;

    ctrl.listItems = ctrl.list[$routeParams.index].items;

    ctrl.getTotalPrice = ctrl.list[$routeParams.index].listTotal;


      console.log(ctrl.list[$routeParams.index].listTotal);
      console.log(ctrl.list[$routeParams.index].items);
      console.log(ctrl.list[$routeParams.index].items[$routeParams.index]);
      // console.log(ctrl.list[$routeParams.index].items[$routeParams.index].stores);

      ctrl.$onInit = function() {
        console.log("Hello");

        ctrl.itemList = ItemService.itemNames;

        ctrl.storeList = ItemService.storeNames;

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
          ctrl.listItems.push({

            "itemId" : ItemService.getIndex(itemName, storeID.storeName),
            "itemName": itemName,
            "itemPrice": storeID.itemPrice,
            "barcode": 0,
            "stores": {
                  "storeName" : storeID.storeName
            }

        });


        ctrl.item = {

            "list": {
                  "listId" : ctrl.list[$routeParams.index].listId
            }
            ,
            "item": {
                "itemId" : ItemService.getIndex(itemName, storeID.storeName)
            }

        }
          //update the total

          ctrl.getTotalPrice += storeID.itemPrice;
          ctrl.getTotalPrice = Math.round((ctrl.getTotalPrice * 100))/100
          console.log(ctrl.getTotalPrice);
          $http.post('http://localhost:8080/lists/additem',JSON.stringify(ctrl.item))
                .then(function(response){
                  if(response.data){
                    console.log(response.data)

                  }
                  else {
                    {
                      console.log("Bad Info");
                    }
                  }
                })

      }


}
