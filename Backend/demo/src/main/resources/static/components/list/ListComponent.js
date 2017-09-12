var dummy = [{
    "id": 1,
    "listname": "Tales from the Organ Trade",
    "listtotal": "$23.71",
    "userid": "89-789-8227"
  }, {
    "id": 2,
    "listname": "Blade",
    "listtotal": "$199.27",
    "userid": "52-133-3171"
  }, {
    "id": 3,
    "listname": "Merry Widow, The",
    "listtotal": "$20.25",
    "userid": "63-533-5035"
  }, {
    "id": 4,
    "listname": "The Siege of Firebase Gloria",
    "listtotal": "$136.58",
    "userid": "14-275-9024"
  }, {
    "id": 5,
    "listname": "My New Gun",
    "listtotal": "$156.00",
    "userid": "30-261-9742"
  }, {
    "id": 6,
    "listname": "Saving Private Ryan",
    "listtotal": "$183.37",
    "userid": "22-228-7691"
  }, {
    "id": 7,
    "listname": "Other End of the Line, The",
    "listtotal": "$68.11",
    "userid": "52-791-1348"
  }, {
    "id": 8,
    "listname": "Unbearable Lightness of Being, The",
    "listtotal": "$121.90",
    "userid": "42-846-3262"
  }, {
    "id": 9,
    "listname": "Caveman",
    "listtotal": "$108.28",
    "userid": "15-734-5760"
  }, {
    "id": 10,
    "listname": "Tyler Perry's The Single Moms Club",
    "listtotal": "$63.83",
    "userid": "03-374-2555"
  }, {
    "id": 11,
    "listname": "Midsummer Night's Sex Comedy, A",
    "listtotal": "$89.04",
    "userid": "52-577-5271"
  }, {
    "id": 12,
    "listname": "Stories We Tell",
    "listtotal": "$161.62",
    "userid": "32-307-3056"
  }, {
    "id": 13,
    "listname": "Starry Eyes",
    "listtotal": "$199.90",
    "userid": "74-197-1850"
  }, {
    "id": 14,
    "listname": "Country Bears, The",
    "listtotal": "$137.75",
    "userid": "60-342-8827"
  }, {
    "id": 15,
    "listname": "Can-Can",
    "listtotal": "$92.08",
    "userid": "47-983-8948"
  }, {
    "id": 16,
    "listname": "Manhattan Melodrama",
    "listtotal": "$142.15",
    "userid": "38-441-4590"
  }, {
    "id": 17,
    "listname": "Assassin of the Tsar",
    "listtotal": "$6.94",
    "userid": "70-269-0413"
  }, {
    "id": 18,
    "listname": "Stockholm, Pennsylvania",
    "listtotal": "$22.61",
    "userid": "11-499-4167"
  }, {
    "id": 19,
    "listname": "Betrayed (True and the Brave, The)",
    "listtotal": "$123.37",
    "userid": "24-774-0795"
  }, {
    "id": 20,
    "listname": "How to Meet Girls from a Distance",
    "listtotal": "$120.56",
    "userid": "53-309-7903"
  }]

var app = angular.module('app');

app.component('listSw',{
    templateUrl: "components/list/list-sw.html",
    controller: ListController
})

function ListController(listObj,$location){
    var ctrl = this;

    ctrl.list = dummy;

    ctrl.getCompleteList = function(l){
        listObj.setObj(l);
        $location.path('/listdetail')
    }
}
