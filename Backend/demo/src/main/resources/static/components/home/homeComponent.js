var app = angular.module('app');

app.component('home',{
    templateUrl: 'components/home/home.html',
    controller: homeController
})

function homeController($mdSidenav, $mdDialog, $location, $http, ListService) {
  var ctrl = this;

  ctrl.$onInit = function() {
      console.log("wassip");
  }

  ctrl.currentUser;

  $http({
    url: 'http://localhost:8080/users/user',
    method: 'GET'
  }).then(function(response){

    ctrl.currentUser = response.data;
    ListService.lists = response.data.lists;

   

  },function(response){
  })


  ctrl.showDialog = function(ev) {
    $mdDialog.show({
      template: '<change-pass></change-pass>',
      targetEvent: ev,
      clickOutsideToClose:true

    }).then(function(answer) {
      console.log(answer);
    }, function() {
      console.log("cancelled");
    })
  }

  //Methods for SIDE BAR
  ctrl.showMobileMainHeader = true;
  ctrl.openSideNavPanel = function() {
    $mdSidenav('left').open();
  };

  ctrl.closeSideNavPanel = function() {
    $mdSidenav('left').close();
  };

  //Methods for the navbar
  ctrl.goto = function(page){
  this.pages = page;
  console.log(page);
  }

  ctrl.logout = function() {
    $location.path("/");
  }
}
