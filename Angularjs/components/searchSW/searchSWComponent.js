var app = angular.module('app');

app.component('searchSw',{
    templateUrl: 'components/searchSW/search-sw.html',
    controller: searchSWController
})

function searchSWController(){
  var ctrl = this;

  ctrl.$onInit = function() {
      console.log("Hello");
  }

  ctrl.print = function(){
    console.log("Hello form the print functions");
  }
}
