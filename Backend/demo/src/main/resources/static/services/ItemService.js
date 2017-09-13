var app = angular.module('app');

app.service('ItemService', function() {
    var ctrl = this;

    ctrl.inventory = [];
    ctrl.itemNames = [];
    ctrl.storeNames = [];

    ctrl.storeInventory = function(items) {
        ctrl.inventory = items;
        for(var i = 0; i < ctrl.inventory.length; i++) {
            if(ctrl.itemNames.indexOf(ctrl.inventory[i].itemName) == -1) {
                ctrl.itemNames.push(ctrl.inventory[i].itemName);
            }

            if(ctrl.storeNames.indexOf(ctrl.inventory[i].stores.storeName) == -1) {
                ctrl.storeNames.push(ctrl.inventory[i].stores.storeName);
            }
        }
    }

    ctrl.getPrice = function(itemName, storeName) {
        for(var i = 0; i < ctrl.inventory.length; i++) {
            if(ctrl.inventory[i].itemName == itemName && ctrl.inventory[i].stores.storeName == storeName) {
                return ctrl.inventory[i].itemPrice;
            }
        }
        return null;
    }

    ctrl.getIndex = function(itemName, storeName) {
        for(var i = 0; i < ctrl.inventory.length; i++) {
            if(ctrl.inventory[i].itemName == itemName && ctrl.inventory[i].stores.storeName == storeName) {
                return ctrl.inventory[i].itemId;
            }
        }
        return -1;
    }

    ctrl.updatePrice = function(itemID, price) {
        for(var i = 0; i < ctrl.inventory.length; i++) {
            if(ctrl.inventory[i].itemId == itemID) {
                ctrl.inventory[i].itemPrice = price;
            }
        }
    }
})