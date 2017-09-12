var dummy1 = [
    [{
        "id": 1,
        "itemname": "Asteraceae",
        "price": "$29.03",
        "barcode": "8296170396"
      }, {
        "id": 2,
        "itemname": "Ranunculaceae",
        "price": "$33.48",
        "barcode": "5516658047"
      }, {
        "id": 3,
        "itemname": "Brassicaceae",
        "price": "$25.92",
        "barcode": "1107791359"
      }, {
        "id": 4,
        "itemname": "Myrtaceae",
        "price": "$20.69",
        "barcode": "6011580750"
      }, {
        "id": 5,
        "itemname": "Brassicaceae",
        "price": "$28.30",
        "barcode": "3270816669"
      }],

      [{
        "id": 1,
        "itemname": "Asteraceae",
        "price": "$3.49",
        "barcode": "7385624723",
        "crossedOff": false
      }, {
        "id": 2,
        "itemname": "Cyperaceae",
        "price": "$6.48",
        "barcode": "5412777457",
        "crossedOff": false
      }, {
        "id": 3,
        "itemname": "Commelinaceae",
        "price": "$1.32",
        "barcode": "7652533465",
        "crossedOff": false
      }, {
        "id": 4,
        "itemname": "Cyperaceae",
        "price": "$32.85",
        "barcode": "8602284179",
        "crossedOff": false
      }, {
        "id": 5,
        "itemname": "Polygonaceae",
        "price": "$13.04",
        "barcode": "4326063297",
        "crossedOff": false
      }, {
        "id": 6,
        "itemname": "Polygonaceae",
        "price": "$5.45",
        "barcode": "8132264991",
        "crossedOff": false
      }, {
        "id": 7,
        "itemname": "Pertusariaceae",
        "price": "$24.49",
        "barcode": "4095665262",
        "crossedOff": false
      }]
]

var app = angular.module('app');

app.component('listdetail',{
    templateUrl: "components/listdetail/listdetail.html",
    controller: ListDetailController
})

function ListDetailController(listObj){
    var ctrl = this;
    ctrl.listtitle = listObj.getObj().listname
    
    ctrl.list = dummy1[listObj.getObj().id];
    //ctrl.crossedOff = false;
    ctrl.crossOff = function(i){
        i.crossedOff = !i.crossedOff
    }
}